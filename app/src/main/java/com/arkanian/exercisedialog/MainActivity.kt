package com.arkanian.exercisedialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.arkanian.exercisedialog.databinding.ActivityMainBinding
import id.sharekom.exercisedialog.ExampleDialogFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnDialogOne.setOnClickListener {
            showDialog()
        }

        binding.btnDialogThree.setOnClickListener {
            showDialogThree()
        }

        binding.btnDialogTwo.setOnClickListener {
            showDialogTwo()
        }

        binding.btnDialogFour.setOnClickListener {
            ExampleDialogFragment(binding.etName.text.toString())
                .show(supportFragmentManager, null)
        }

        val view = binding.root
        setContentView(view)
    }

    fun showDialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog Cencelable")
        dialog.setMessage("Bisa di tutup")
        dialog.setCancelable(true)
        dialog.show()
    }

    fun showDialogTwo(){
        val dialog = AlertDialog.Builder(this)
            .setTitle("Dialog Title")
            .setMessage("Dialog Dengan Action Button")
            .setCancelable(false)
            .setPositiveButton("Yes"){ dialog, _ ->
                Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }.setNegativeButton("No"){ dialog, _ ->
                Toast.makeText(this, "No", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }.setNeutralButton("Cancel"){ dialog, _ ->
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        dialog.show()
    }

    fun showDialogThree(){
        val view = LayoutInflater.from(this).inflate(R.layout.costum_dialog, null, false)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(view)
        val dialog = dialogBuilder.create()
        view.findViewById<Button>(R.id.btn_Ok).setOnClickListener {
            Toast.makeText(this, "Costume Dialog Closed", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialog.show()
    }
}