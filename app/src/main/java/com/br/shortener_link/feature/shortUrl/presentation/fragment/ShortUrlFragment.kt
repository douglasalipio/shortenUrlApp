package com.br.shortener_link.feature.shortUrl.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.br.shortener_link.R
import com.br.shortener_link.databinding.FragmentShortUrlBinding
import com.br.shortener_link.feature.shortUrl.presentation.model.LinkUiModel
import com.br.shortener_link.feature.shortUrl.presentation.model.ShortUiModel
import com.br.shortener_link.feature.shortUrl.presentation.view.viewaction.ShortUrlViewAction
import com.br.shortener_link.feature.shortUrl.presentation.view.viewmodel.ShortUrlViewModel
import com.br.shortener_link.feature.shortUrl.presentation.view.viewstate.ShortUrlViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShortUrlFragment : Fragment(R.layout.fragment_short_url) {

    private val viewBinding by viewBinding(FragmentShortUrlBinding::bind)
    private val viewModel: ShortUrlViewModel by viewModel()
    private val saveUrlActionClick: (String) -> Unit = this::onSaveUrlActionClicked

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewComponents()
        setUpEvents()
    }

    private fun setUpEvents() {
        viewModel.viewState.action.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ShortUrlViewState.Action.ShowSuccess -> updateShortUrlList(state.shortUiModel)
                is ShortUrlViewState.Action.ShowError -> showError()
            }
        }
    }

    private fun onSaveUrlActionClicked(urlString: String) {
        val saveUrlAction = ShortUrlViewAction.SaveShortUrlClicked(urlString)
        viewModel.dispatchViewAction(saveUrlAction)
    }

    private fun updateShortUrlList(shortUiModel: ShortUiModel) {
        viewBinding.shortUrlListView.setUpView()
        viewBinding.shortUrlListView.addItem(shortUiModel)
    }

    private fun setUpViewComponents() {
        viewBinding.shortUrlView.setOnclickListener(saveUrlActionClick)
    }

    private fun showError() {
        Toast.makeText(
            requireContext(),
            "Error 404",
            Toast.LENGTH_LONG
        ).show()
        //TODO As the alias api is always returns 404.
        // I've added manually the shortUrl object to the recycler list in order to show the feature usage.
        updateShortUrlList(ShortUiModel("alias", LinkUiModel("self", "short")))
    }
}