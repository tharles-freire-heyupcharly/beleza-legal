package com.mackenzie.belezalegal

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.mackenzie.belezalegal.databinding.FragmentHandoutInformalBinding
import java.io.File
import java.io.FileOutputStream
import java.net.URL


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HandoutInformalFragment : Fragment() {
    private val viewModel: SharedViewModel by activityViewModels()
    private var _binding: FragmentHandoutInformalBinding? = null
    private val url = "https://drive.google.com/uc?export=download&id=1_nDz1P5_aPzMaCTdPe-qBgLLHqEBgCWg"


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHandoutInformalBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.textviewToptext.setText(viewModel.answer1.value.toString())


        val pdfView = binding.pdfView
        //pdfView.fromUri(Uri.parse("https://drive.google.com/file/d/1_nDz1P5_aPzMaCTdPe-qBgLLHqEBgCWg"))
        pdfView.fromAsset("handoutinformal.pdf")
            .enableSwipe(true) // allows to block changing pages using swipe
            .swipeHorizontal(true)
            .pageSnap(true)
            .autoSpacing(true)
            .pageFling(true)
            .load();

        binding.saveToPdf.setOnClickListener { view ->
            downloadPdf(url)

            Snackbar.make(view, "Download PDF", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }



        binding.buttonNext.setOnClickListener {

            findNavController().navigate(R.id.action_handoutInformalFragment_to_acknowledgementsFragment)
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun downloadPdf(url: String) {

        val request = DownloadManager.Request(Uri.parse(url))
        request.setTitle("Cartilha Beleza Legal")
        request.setDescription("Downloading PDF file")
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "cartilhaformalizese.pdf")
        request.setMimeType("application/pdf")

        val manager = context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager?
        manager!!.enqueue(request)
    }


}