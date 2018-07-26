package com.beiing.twopagelayout.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by chenliu on 2016/9/28.<br/>
 * 描述：淘宝详情页
 * </br>
 */
public class TwoPageLayout extends LinearLayout {

    private ScrollEndScrollView scrollView1;

    private ScrollEndScrollView scrollView2;

    /**
     * scrollView1是否滚动到底部
     */
    private boolean isToBotttom;

    /**
     * scrollView2是否滚动到顶部
     */
    private boolean isToTop;


    /**
     * 第一页是否大于一屏
     */
    private boolean isOverScreen;


    private Scroller mScroller; //滑动控制器

    private int mMoveY;
    private int mLastY;

    private int TO_NEXT_PAGE_HEIGHT = 400;//当再移动这个距离，就移动到下一页

    private byte pageIndex = 0;

    public TwoPageLayout(Context context) {
        this(context, null, 0);
    }

    public TwoPageLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TwoPageLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        mScroller = new Scroller(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /**
         * 显示调用第二个自孩子的测量方法，不然尺寸有可能为0
         */
        View child2 = getChildAt(1);
        if (child2 != null) {
            child2.measure(widthMeasureSpec, heightMeasureSpec);
        }

        isOverScreen = !(scrollView1.getChildAt(0).getMeasuredHeight() <= MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if(getChildCount() == 2){
            View child1 = getChildAt(0);
            if (child1 instanceof ScrollEndScrollView){
                scrollView1 = (ScrollEndScrollView) child1;
                //强制设置第一页为MATCH_PARENT，不然当小于屏幕高度时，第二页会显示出来
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                scrollView1.setLayoutParams(layoutParams);
            }
            View child2 = getChildAt(1);
            if(child2 instanceof ScrollEndScrollView){
                scrollView2 = (ScrollEndScrollView) child2;
            }
        }

        initEvent();
    }

    private void initEvent() {
        if (scrollView1 != null) {
            scrollView1.addOnScrollEndListener(scrollEndListener);
        }
        if (scrollView2 != null) {
            scrollView2.addOnScrollEndListener(scrollEndListener);
        }
    }

    private ScrollEndScrollView.OnScrollEndListener scrollEndListener = new ScrollEndScrollView.OnScrollEndListener() {
        @Override
        public void scrollToBottom(View view) {
            if(view == scrollView1){
                isToBotttom = true;
            }
        }

        @Override
        public void scrollToTop(View view) {
            if(view == scrollView2){
                isToTop = true;
            }
        }

        @Override
        public void scrollToMiddle(View view) {
            if(view == scrollView1){
                isToBotttom = false;
            }
            if(view == scrollView2){
                isToTop = false;
            }
        }
    };


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        int yPosition = (int) ev.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mScroller.abortAnimation();
                mLastY = yPosition;
                mMoveY = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                mMoveY = (mLastY - yPosition);
                mLastY = yPosition;

                if(!isOverScreen && pageIndex == 0){
//                    if(mMoveY < 0){
//                        // 向下
//                        isToTop = true;
//                        isToBotttom = false;
//                    } else if(mMoveY > 0){
//                        isToTop = false;
//                        isToBotttom = true;
//                    }

                    isToBotttom = true;
                }

                if(isToBotttom){
                    if(mMoveY > 0){
                        //向上
                        smoothScrollBy(0, mMoveY);
                        return true;
                    } else {
                        //向下
                        if(mScroller.getFinalY() != 0){
                            //这是出于第一页和第二页显示连接处
                            if(getScrollY() + mMoveY > 0){
                                smoothScrollBy(0, mMoveY);
                                return true;
                            } else{
                                smoothScrollTo(0, 0);
                            }
                        }
                    }
                }
                else if(isToTop){
                    if(mMoveY < 0){
                        //向下
                        smoothScrollBy(0, mMoveY);
                        return true;
                    } else {
                        //向上
                        if(mScroller.getFinalY() < scrollView1.getHeight()){
                            //这是出于第一页和第二页显示连接处
                            smoothScrollBy(0, mMoveY);
                            return true;
                        } else {
                            smoothScrollTo(0, scrollView1.getHeight());
                        }
                    }
                }
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }

    /**
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        int yPosition = (int) ev.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mScroller.abortAnimation();
                mLastY = yPosition;
                mMoveY = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                mMoveY = (mLastY - yPosition);
                mLastY = yPosition;
                if(isToBotttom){
                    if(mMoveY > 0){
                        //向上
                        smoothScrollBy(0, mMoveY);
                        return true;
                    } else {
                        //向下
                        if(mScroller.getFinalY() != 0){
                            //这是出于第一页和第二页显示连接处
                            if(getScrollY() + mMoveY > 0){
                                smoothScrollBy(0, mMoveY);
                                return true;
                            } else{
                                smoothScrollTo(0, 0);
                            }
                        }
                    }
                }
                else if(isToTop){
                    if(mMoveY < 0){
                        //向下
                        smoothScrollBy(0, mMoveY);
                        return true;
                    } else {
                        //向上
                        if(mScroller.getFinalY() < scrollView1.getHeight()){
                            //这是出于第一页和第二页显示连接处
                            smoothScrollBy(0, mMoveY);
                            return true;
                        } else {
                            smoothScrollTo(0, scrollView1.getHeight());
                        }
                    }
                }

                //处理快速滑动时两页覆盖问题
                if(pageIndex == 0){
                    smoothScrollTo(0, 0);
                } else if(pageIndex == 1){
                    smoothScrollTo(0, scrollView1.getHeight());
                }

                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if(isToBotttom){
                   if(Math.abs(getScrollY()) > TO_NEXT_PAGE_HEIGHT){
                        //移动到第二页
                       pageIndex = 1;
                       smoothScrollTo(0, scrollView1.getHeight());
                       isToBotttom = false;
                       isToTop = true;
                    } else {
                        //回弹
                        smoothScrollBy(0, -mScroller.getFinalY());
                    }
                } else if(isToTop){
                    if(scrollView1.getHeight() - getScrollY() > TO_NEXT_PAGE_HEIGHT){
                        //移动到第一页
                        pageIndex = 0;
                        smoothScrollTo(0, 0);
                        isToBotttom = true;
                        isToTop = false;
                    } else {
                        //回弹
                        smoothScrollTo(0, scrollView1.getHeight());
                    }
                }

                break;
            default:
                break;
        }

        return super.onTouchEvent(ev);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        //先判断mScroller滚动是否完成
        if (mScroller.computeScrollOffset()) {
            //这里调用View的scrollTo()完成实际的滚动
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            //必须调用该方法，否则不一定能看到滚动效果
            postInvalidate();
        }
    }

    //调用此方法滚动到目标位置
    public void smoothScrollTo(int fx, int fy) {
        int dx = fx - mScroller.getFinalX();
        int dy = fy - mScroller.getFinalY();
        smoothScrollBy(dx, dy);
    }

    //调用此方法设置滚动的相对偏移
    public void smoothScrollBy(int dx, int dy) {
        //设置mScroller的滚动偏移量
        mScroller.startScroll(mScroller.getFinalX(), mScroller.getFinalY(), dx, dy, Math.max(300, Math.abs(dy)));
        invalidate();//这里必须调用invalidate()才能保证computeScroll()会被调用，否则不一定会刷新界面，看不到滚动效果
    }
}
