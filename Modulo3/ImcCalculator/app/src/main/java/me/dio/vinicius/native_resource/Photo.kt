package me.dio.vinicius.native_resource

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import me.dio.vinicius.native_resource.databinding.ActivityPhotoBinding

class Photo : AppCompatActivity() {

    lateinit var binding: ActivityPhotoBinding

    companion object {
        private val PERMISSION_CODE = 1000
        private val IMAGE_PICK_CODE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btChooseImage.setOnClickListener{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
               if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
               == PackageManager.PERMISSION_DENIED){
                   val permission = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                   requestPermissions(permission, PERMISSION_CODE)
               }else {
                   pickImageFromGallery()
               }
            }
            else{
                pickImageFromGallery()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    pickImageFromGallery(requestCode)
                else
                    Toast.makeText(this, "Permissão Negada", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun pickImageFromGallery(requestCode : Int) {
        //FIXME Encontrar a nova solução para recuperar uma imagem da galeria
//        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
//            if(result.resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
//                binding.ivSelectedImage.setImageURI(data?.data)
//            }
//        }
//
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        startActivityForResult(intent, IMAGE_PICK_CODE)
    }


}