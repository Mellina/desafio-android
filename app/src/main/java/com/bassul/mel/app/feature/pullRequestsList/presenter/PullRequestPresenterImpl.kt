package com.bassul.mel.app.feature.pullRequestsList.presenter

import com.bassul.mel.app.domain.PullRequest
import com.bassul.mel.app.feature.pullRequestsList.PullRequestListContract

class PullRequestPresenterImpl(val view: PullRequestListContract.View) :
    PullRequestListContract.Presenter {

    override fun openListPullRequest(pullRequest: ArrayList<PullRequest>) =
        if (pullRequest.isEmpty()) {
            view.showTextEmptyList()
        } else {
            view.showPullRequestList(pullRequest)
        }

    override fun errorShowPullRequest(errorPullRequest: Int) {
        view.showErrorPullRequestList(errorPullRequest)
    }

}