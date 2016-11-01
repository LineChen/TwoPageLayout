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

#License

```
   Copyright 2016 LineChen <15764230067@163.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
