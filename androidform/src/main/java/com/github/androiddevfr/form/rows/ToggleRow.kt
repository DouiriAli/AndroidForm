package com.github.androiddevfr.form.rows

import android.content.Context
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.ToggleButton
import com.github.androiddevfr.form.core.DimensionUtils

class ToggleRow(context: Context): AbstractTitleRow<Boolean>(context) {

    var toggleView: ToggleButton? = null
    var textOff: String = ""
    var textOn: String = ""
    private var value: Boolean? = null

    override fun value(): Boolean? = value

    var customizeToggleView: ((ToggleRow, ToggleButton) -> Unit) = { _, _ -> }

    init {
        onCreateView<ToggleRow> {
            val layout = RelativeLayout(context)

            //Generated the Slider
            createToggle()
            val toggleLayoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            toggleLayoutParams.leftMargin = DimensionUtils.dpToPx(AbstractTitleRow.DEFAULT_MARGIN_LEFT)
            toggleLayoutParams.topMargin = DimensionUtils.dpToPx(AbstractTitleRow.DEFAULT_MARGIN_TOP)
            toggleLayoutParams.bottomMargin = DimensionUtils.dpToPx(AbstractTitleRow.DEFAULT_MARGIN_BOTTOM)
            toggleLayoutParams.rightMargin = DimensionUtils.dpToPx(AbstractTitleRow.DEFAULT_MARGIN_RIGHT)
            toggleLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL)
            toggleLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
            toggleView?.layoutParams = toggleLayoutParams
            layout.addView(toggleView)


            //Generated the Title
            createTitleView(TITLE_VIEW_ID)
            val titleLayoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            titleLayoutParams.leftMargin = DimensionUtils.dpToPx(AbstractTitleRow.DEFAULT_MARGIN_LEFT)
            titleLayoutParams.topMargin = DimensionUtils.dpToPx(AbstractTitleRow.DEFAULT_MARGIN_TOP)
            titleLayoutParams.bottomMargin = DimensionUtils.dpToPx(AbstractTitleRow.DEFAULT_MARGIN_BOTTOM)
            titleLayoutParams.rightMargin = DimensionUtils.dpToPx(AbstractTitleRow.DEFAULT_MARGIN_RIGHT)
            titleLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL)
            titleLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
            titleView?.layoutParams = titleLayoutParams
            layout.addView(titleView)

            layout
        }
    }

    /**
     * Use this lambda to change the visual aspect of the ToggleView
     */
     private fun createToggle(): ToggleButton {
        toggleView = ToggleButton(context)
        toggleView?.text = textOff
        toggleView?.textOn = textOn
        toggleView?.textOff = textOff
        customizeToggleView.invoke(this, toggleView as ToggleButton)
        toggleView?.setOnCheckedChangeListener{ _, isChecked -> value = isChecked }
        return toggleView as ToggleButton
    }

}