package com.bassul.mel.app.callback

import com.bassul.mel.app.repositoriesList.repository.model.PullRequestListResponse


interface RepositotySelectedRepositoriesCallback {
    fun onSuccess(pullRequestList : PullRequestListResponse)
}