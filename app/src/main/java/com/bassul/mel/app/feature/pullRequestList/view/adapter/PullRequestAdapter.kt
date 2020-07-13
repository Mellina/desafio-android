package com.bassul.mel.app.feature.pullRequestList.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bassul.mel.app.R
import com.bassul.mel.app.domain.PullRequest
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_pull_request_item.view.*
import kotlinx.android.synthetic.main.layout_pull_request_item.view.lpr_im_avatar

class PullRequestAdapter (private val context: Context, var pr : MutableList<PullRequest>, private val itemClickListener: (PullRequest) -> Unit) : RecyclerView.Adapter<PullRequestAdapter.ViewHolder>(),
    AdapterPullRequestContract {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_pull_request_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pullRequest = pr[position]

        holder?.name.text = pullRequest.userName
        holder?.body.text = pullRequest.body
        holder?.nameOwner.text = pullRequest.userName
        Picasso.get().load(pullRequest.userAvatar).into(holder?.avatarOwner)
        holder?.date.text = pullRequest.updated_at
        holder?.clickableView.setOnClickListener {
            itemClickListener(pullRequest)
        }


        if(position + 1 == pr.size){
         //   holder.changeVisibility(true)
        }else{
        //    holder.changeVisibility(false)
        }
/*
        holder.clickableView.setOnClickListener {
            itemClickListener(item)
        }*/

    }

    override fun addItems(newItems: List<PullRequest>) {
        pr.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = pr.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

        var name = itemView.lpr_tx_pull_request_title!!
        var body = itemView.lpr_tx_pull_request_body!!
        var avatarOwner = itemView.lpr_im_avatar
        var nameOwner = itemView.lpr_tx_name_owner
        var date = itemView.lpr_tx_date
      //  var progressBar = itemView.lpr_progressbar
        var clickableView = itemView.cardViewPullRequest
/*
        fun changeVisibility(isLastItem : Boolean){
            if(isLastItem){
                setVisibilityLoading(View.VISIBLE)
                setVisibilityItem(View.INVISIBLE)
            }else{
                setVisibilityLoading(View.INVISIBLE)
                setVisibilityItem(View.VISIBLE)
            }
        }*/

   /*     private fun setVisibilityItem(visibility : Int) {
            name.visibility = visibility
            description.visibility = visibility
            avatarOwner.visibility = visibility
            nameOwner.visibility = visibility
            stars.visibility = visibility
            forks.visibility = visibility
            starImage.visibility = visibility
            forkImage.visibility = visibility
        }

        private fun setVisibilityLoading(visibility : Int){
            progressBar.visibility = visibility
        }*/

    }

}

