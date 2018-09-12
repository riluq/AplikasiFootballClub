package com.riluq.aplikasifootballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*


class DetailActivity : AppCompatActivity() {

    private var nameClubDetail: String = ""
    private var imageClubDetail: Int = 0
    private var descriptionClubDetail: String = ""

    lateinit var detailActivityUI: DetailActivityUI


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailActivityUI = DetailActivityUI()
        detailActivityUI.setContentView(this)

        val intent = intent
        nameClubDetail = intent.getStringExtra("name")
        imageClubDetail = intent.getIntExtra("image", 0)
        descriptionClubDetail = intent.getStringExtra("description")


        detailActivityUI.nameClubDetailUI.text = nameClubDetail
        Glide.with(this).load(imageClubDetail).into(detailActivityUI.imageClubDetailUI)
        detailActivityUI.descriptionClubDetailUI.text = descriptionClubDetail

    }

    class DetailActivityUI : AnkoComponent<DetailActivity> {
        lateinit var imageClubDetailUI: ImageView
        lateinit var nameClubDetailUI: TextView
        lateinit var descriptionClubDetailUI: TextView

        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {

            scrollView {

                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.VERTICAL

                    imageClubDetailUI = imageView {
                        id = R.id.detailImageId
                        imageResource = R.drawable.img_barca
                    }.lparams {
                        width = dip(50)
                        height = dip(50)
                        gravity = Gravity.CENTER_HORIZONTAL
                    }

                    nameClubDetailUI =  textView {
                        id = R.id.detailNamedId
                        textSize = 16f
                        text = "Barcelona FC"
                    }.lparams {
                        margin = dip(15)
                        gravity = Gravity.CENTER_HORIZONTAL
                    }

                    descriptionClubDetailUI = textView {
                        id = R.id.detailDescriptionId
                        textSize = 16f
                        text = "nhyubgdyuhbhshbnweyghduwendjkbhewudiwejnhduhweuidnhweuihduiwendhweuihndiwehjui9djwejihd"
                    }.lparams {
                        margin = dip(15)
                    }
                }
            }


        }

    }
}
