package com.example.currentnews.views.news

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.currentnews.databinding.FragmentAddNewsBinding
import com.example.currentnews.extension.toBase64
import com.example.currentnews.models.Screen
import com.example.currentnews.models.user.AccessResultModel
import com.example.currentnews.viewmodel.NewsViewModel
import com.example.currentnews.views.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNewsFragment : Fragment() {

    var binding: FragmentAddNewsBinding? = null
    private val viewModelAddNews: NewsViewModel by viewModels()
    var permissionCount = 0
    var REQUEST_PERMISSION_CAMERA = 1001
    var REQUEST_PERMISSON_WRITE_EXTERNAL_STORAGE = 1002
    var ID_ACT_CAMERA = 20001

    var photoArray: ByteArray? = null
    var photoBase64: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNewsBinding.inflate(
            LayoutInflater.from(context), null, false
        )

        binding?.ivAddImg?.setOnClickListener {
            if (permissionCount > 0) {
                issueCameraIntent()
            }
        }

        binding?.btnSave?.setOnClickListener {
            // programacion para guardar información

            addNewNewsRegister(
                binding?.tietTitle?.text.toString(),
                binding?.tietNew?.text.toString(),
                //Preguntar a marco
                photoBase64.toString()
            )
        }

        iniCam()
        initAddNewsObserver()
        return binding?.root
    }

    private fun initAddNewsObserver() {
        viewModelAddNews.addNewsResult.observe(viewLifecycleOwner, addNewsR)
    }

    private fun issueCameraIntent() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, ID_ACT_CAMERA)
    }

    // Callback
    private val addNewsR = Observer<AccessResultModel> { accessResultModel ->
        if (accessResultModel.code == "0") {
            Toast.makeText(requireContext(), "Successful registration", Toast.LENGTH_SHORT).show()
            (activity as MainActivity)
                .changeScreenProccess(Screen.LoginFragment)
        } else {
            Toast.makeText(requireContext(), "an error has ocurred", Toast.LENGTH_SHORT).show()
        }
    }

    fun addNewNewsRegister(title: String, news: String, image: String) {
        viewModelAddNews.addNewsValidation(title, news, image)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ID_ACT_CAMERA && resultCode == RESULT_OK) {

            val b: Bitmap? = data?.extras?.getParcelable("data")
            // photoArray = b?.toByteArray(10)
            photoBase64 = b?.toBase64()

            binding?.ivImageNew?.setImageBitmap(b)
        }
    }

    fun iniCam() {

        // request permissions at runtime
        permissionCount = 0

        if (checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(Manifest.permission.CAMERA), REQUEST_PERMISSION_CAMERA)
        } else {
            permissionCount++
        }

        if (checkSelfPermission(
                requireContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_PERMISSON_WRITE_EXTERNAL_STORAGE
            )
        } else {
            permissionCount++
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            AddNewsFragment().apply {
                arguments = Bundle().apply { }
            }
    }
}
