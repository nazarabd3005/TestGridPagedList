package com.nazar.testgridandroid.datasource

import androidx.paging.PageKeyedDataSource
import com.nazar.testgridandroid.model.ImageItem
import com.nazar.testgridandroid.model.ImageResponse
import com.nazar.testgridandroid.service.Service
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class ImageListDataSource(
    private val service: Service,
    private val compositeDisposable: CompositeDisposable
) : PageKeyedDataSource<Int, ImageItem>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ImageItem>
    ) {
        service.getImageList(1, params.requestedLoadSize)
            .subscribe(object : SingleObserver<ImageResponse> {
                override fun onSuccess(t: ImageResponse) {
                    t.photos.takeIf { it.size > 0 }?.let {
                        callback.onResult(
                            it,
                            null,
                            2
                        )
                    }
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                    throw Exception(e)
                }
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ImageItem>) {
        service.getImageList(params.key, params.requestedLoadSize)
            .subscribe(object : SingleObserver<ImageResponse> {
                override fun onSuccess(t: ImageResponse) {
                    t.photos.takeIf { it.size > 0 }?.let {
                        callback.onResult(
                            it,
                            params.key + 1
                        )
                    }
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                    throw Exception(e)
                }
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ImageItem>) {

    }
}