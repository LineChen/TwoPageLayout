# TwoPageLayout
重写LinearLayout，仿淘宝商品详情页，上拉查看更多详情

![效果图](https://github.com/LineChen/TwoPageLayout/blob/master/screenshot/sh.gif)

##使用

- 布局:TwoPageLayout作为父布局，内部有且只能有两个子控件ScrollEndScrollView

```java
<com.beiing.twopagelayout.widget.TwoPageLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.beiing.twopagelayout.widget.ScrollEndScrollView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:visibility="visible">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical">
                <ImageView
                    android:layout_width="match_parent"
                    android:scaleType="centerCrop"
                    android:layout_height="200dp"
                    android:background="@mipmap/m1"
                    />

                <ImageView
                    android:layout_width="match_parent"
                    android:scaleType="centerCrop"
                    android:layout_height="200dp"
                    android:background="@mipmap/m2"
                    />

                <ImageView
                    android:layout_width="match_parent"
                    android:scaleType="centerCrop"
                    android:layout_height="200dp"
                    android:background="@mipmap/m3"
                    />

                <ImageView
                    android:layout_width="match_parent"
                    android:scaleType="centerCrop"
                    android:layout_height="200dp"
                    android:background="@mipmap/m4"
                    />

                <ImageView
                    android:layout_width="match_parent"
                    android:scaleType="centerCrop"
                    android:layout_height="200dp"
                    android:background="@mipmap/m8"
                    />

                <ImageView
                    android:layout_width="match_parent"
                    android:scaleType="centerCrop"
                    android:layout_height="200dp"
                    android:background="@mipmap/m9"
                    />

                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:padding="30dp"
                    android:background="#2888"
                    android:gravity="center"
                    android:text="继续拖动，查看更多美女"
                    />

            </LinearLayout>

        </com.beiing.twopagelayout.widget.ScrollEndScrollView>

        <com.beiing.twopagelayout.widget.ScrollEndScrollView
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical">
                <ImageView
                    android:layout_width="match_parent"
                    android:scaleType="centerCrop"
                    android:layout_height="200dp"
                    android:background="@mipmap/m5"
                    />

                <ImageView
                    android:layout_width="match_parent"
                    android:scaleType="centerCrop"
                    android:layout_height="200dp"
                    android:background="@mipmap/m6"
                    />

                <ImageView
                    android:layout_width="match_parent"
                    android:scaleType="centerCrop"
                    android:layout_height="200dp"
                    android:background="@mipmap/m7"
                    />

                <ImageView
                    android:layout_width="match_parent"
                    android:scaleType="centerCrop"
                    android:layout_height="200dp"
                    android:background="@mipmap/m10"
                    />

                <ImageView
                    android:layout_width="match_parent"
                    android:scaleType="centerCrop"
                    android:layout_height="200dp"
                    android:background="@mipmap/m11"
                    />

                <ImageView
                    android:layout_width="match_parent"
                    android:scaleType="centerCrop"
                    android:layout_height="200dp"
                    android:background="@mipmap/ruhua"
                    />

                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:padding="30dp"
                    android:background="#2888"
                    android:gravity="center"
                    android:text="已经到底了"
                    />
            </LinearLayout>

        </com.beiing.twopagelayout.widget.ScrollEndScrollView>


    </com.beiing.twopagelayout.widget.TwoPageLayout>

```

## [详细介绍请看：自定义LinearLayout实现淘宝详情页](http://blog.csdn.net/u011102153/article/details/52703119)


