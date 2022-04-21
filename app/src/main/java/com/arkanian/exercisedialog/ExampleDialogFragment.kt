package id.sharekom.exercisedialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.arkanian.exercisedialog.R

class ExampleDialogFragment(private val name: String) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_dialog_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (name.isNotEmpty()) {
            val textView = view.findViewById<TextView>(R.id.tv_hello)
            textView.text = name
        }

        val btnTutup = view.findViewById<Button>(R.id.btn_tutup)
        btnTutup.setOnClickListener {
            Toast.makeText(requireContext(), "DialogFragment Ditutup dari dalam fragment", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}