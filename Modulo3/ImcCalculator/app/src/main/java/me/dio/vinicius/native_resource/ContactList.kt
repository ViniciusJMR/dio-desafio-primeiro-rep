package me.dio.vinicius.native_resource

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.dio.vinicius.native_resource.adapter.ContactAdapter
import me.dio.vinicius.native_resource.databinding.ActivityContactListBinding
import me.dio.vinicius.native_resource.domain.Contact

class ContactList : AppCompatActivity() {

    lateinit var binding: ActivityContactListBinding;
    val REQUEST_CONTACT = 1
    val LINEAR_LAYOUT_VERTICAL = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactListBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.READ_CONTACTS), REQUEST_CONTACT)
        } else {
            setContacts()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1)
            setContacts()
    }

    //FIXME Encontrar uma forma de solucionar o problema do getColumnIndex que não ocorre no video
    @SuppressLint("Range")
    fun setContacts(){
        val contactList: ArrayList<Contact> = ArrayList()

        val cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
        null, null, null, null)

        if (cursor != null){
            while (cursor.moveToNext()){
                val name = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                val number = ContactsContract.CommonDataKinds.Phone.NUMBER
                val nameColumn = cursor.getColumnIndex(name)
                val numberColumn = cursor.getColumnIndex(number)
                if (nameColumn >= 1 && numberColumn >= 1){
                    contactList.add(Contact(
                        cursor.getString(cursor.getColumnIndex(name)),
                        cursor.getString(cursor.getColumnIndex(number))
                    ))
                }

            }
            cursor.close()
        }

        binding.rvContactList.layoutManager = LinearLayoutManager(this,
                LINEAR_LAYOUT_VERTICAL,
                false
            )
        binding.rvContactList.adapter = ContactAdapter(contactList)
    }
}