package com.github.androiddevfr.form.rows

import android.content.Context
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Switch
import com.github.androiddevfr.form.core.DimensionUtils

class SwitchRow (context: Context): AbstractTitleRow<Boolean>(context) {

    var switch: Switch? = null
    private var value: Boolean? = null

    override fun value(): Boolean? = value

    var customizeSwitchView: ((SwitchRow, Switch) -> Unit) = { _, _ -> }

    init {
        onCreateView<SwitchRow> {
            val layout = RelativeLayout(context)

            //Generated the Switch
            createSwitch()
            val switchLayoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            switchLayoutParams.leftMargin = DimensionUtils.dpToPx(DEFAULT_MARGIN_LEFT)
            switchLayoutParams.topMargin = DimensionUtils.dpToPx(DEFAULT_MARGIN_TOP)
            switchLayoutParams.bottomMargin = DimensionUtils.dpToPx(DEFAULT_MARGIN_BOTTOM)
            switchLayoutParams.rightMargin = DimensionUtils.dpToPx(DEFAULT_MARGIN_RIGHT)
            switchLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL)
            switchLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
            switch?.layoutParams = switchLayoutParams
            layout.addView(switch)

            //Generated the Title
            createTitleView(TITLE_VIEW_ID)
            val titleLayoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            titleLayoutParams.leftMargin = DimensionUtils.dpToPx(DEFAULT_MARGIN_LEFT)
            titleLayoutParams.topMargin = DimensionUtils.dpToPx(DEFAULT_MARGIN_TOP)
            titleLayoutParams.bottomMargin = DimensionUtils.dpToPx(DEFAULT_MARGIN_BOTTOM)
            titleLayoutParams.rightMargin = DimensionUtils.dpToPx(DEFAULT_MARGIN_RIGHT)
            titleLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL)
            titleLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
            titleView?.layoutParams = titleLayoutParams
            layout.addView(titleView)

            layout
        }
    }

    /**
     * Use this lambda to change the visual aspect of the SwitchView
     */
    private fun createSwitch(): Switch {
        switch = Switch(context)
        customizeSwitchView.invoke(this, switch as Switch)
        switch?.setOnCheckedChangeListener{ _, isChecked -> value = isChecked }
        return switch as Switch
    }

}