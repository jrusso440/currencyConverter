package bu.edu.conversioncalc

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.Log.*
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


open class MainActivity : AppCompatActivity() {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the reference of the submit button
        val submitBtn: Button = findViewById<Button>(R.id.buttonId_submit)
        // register the button with an OnClickListener
        submitBtn.setOnClickListener { view -> onClickSubmit(view) }
    }

    @SuppressLint("ServiceCast")
    fun onClickSubmit(v: View) {
        v.clearFocus()
        // get the name from the EditText
        val dollarEditText: EditText = findViewById<EditText>(R.id.editTextId_dollars)
        Log.d(TAG,"(((((((())))))")
        Log.d(TAG,dollarEditText.text.toString())
        val dollarStr: String = dollarEditText.text.toString()
        Log.d(TAG,dollarStr)
         val dollar = dollarStr.toInt().toDouble()
        Log.d(TAG,dollar.toString())
        /* let's now convert */
        val euro = 0.97 *dollar
        val euroStr = euro.toString()
        // compose a message from the above information
        val euroEditText: EditText = findViewById<EditText>(R.id.editTextId_euros)
        euroEditText.setText(euroStr)
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(v.windowToken, 0)
    }

    companion object {
        private const val TAG = "MyApp"
    }
}
