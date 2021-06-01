package com.cloudless.paypay.ui.addproduct

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudless.paypay.data.tflite.Clasiffier
import com.cloudless.paypay.data.tflite.TensorFlowImage
import com.cloudless.paypay.databinding.FragmentAddProductBinding
import com.wonderkiln.camerakit.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors


class AddProductFragment : Fragment() {
    private lateinit var binding: FragmentAddProductBinding
    private lateinit var classifier: Clasiffier

    companion object {
        private const val MODEL_PATH: String = "mobilenetv2_2nd_model.tflite"
        private const val QUANT: Boolean = false
        private const val LABEL_PATH: String = "labels.txt"
        private const val INPUT_SIZE: Int = 224
    }

    private val executor: Executor = Executors.newSingleThreadExecutor()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddProductBinding.inflate(layoutInflater, container, false)
        binding.cameraView.addCameraKitListener(object  : CameraKitEventListener{
            override fun onVideo(p0: CameraKitVideo?) {

            }

            override fun onEvent(p0: CameraKitEvent?) {

            }

            override fun onImage(p0: CameraKitImage?) {
                var bitmap: Bitmap? = p0?.bitmap
                bitmap = bitmap?.let { Bitmap.createScaledBitmap(it, INPUT_SIZE, INPUT_SIZE, false) }
                binding.imgProduct.setImageBitmap(bitmap)
                val result: List<Clasiffier.Recognition> = classifier.reconizeImage(bitmap) as List<Clasiffier.Recognition>
                binding.tvNama.text = result.toString()
            }

            override fun onError(p0: CameraKitError?) {

            }
        })
        binding.btncamera.setOnClickListener {
            binding.cameraView.captureImage()
        }
        initTensorFlowLoadModel()
        return binding.root
    }
    override fun onResume() {
        super.onResume()
        binding.cameraView.start()
    }
    override fun onPause() {
        super.onPause()
        binding.cameraView.stop()
    }
    override fun onDestroy() {
        super.onDestroy()
        executor.execute { classifier.close() }
    }
    private fun initTensorFlowLoadModel(){
        executor.execute {
            try {
                classifier = TensorFlowImage.create(
                        activity?.assets,
                        MODEL_PATH,
                        LABEL_PATH,
                        INPUT_SIZE,
                        QUANT);
            } catch (e: Exception) {
                throw RuntimeException("Error initializing TensorFlow!", e)
            }
        }
    }
}