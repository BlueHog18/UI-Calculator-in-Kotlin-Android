//This is the main kotlin File
var check = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edvalues.isActivated
        edvalues.isPressed

        btn0.setOnClickListener {
            val text = edvalues.text.toString()+"0"
            edvalues.setText(text)
            result(text)
        }
        btndot.setOnClickListener {
            val text = edvalues.text.toString()+"."
            edvalues.setText(text)
            result(text)
        }
        btn1.setOnClickListener {
            val text = edvalues.text.toString()+"1"
            edvalues.setText(text)
            result(text)
        }
        btn2.setOnClickListener {
            val text = edvalues.text.toString()+"2"
            edvalues.setText(text)
            result(text)
        }
        btn3.setOnClickListener {
            val text = edvalues.text.toString()+"3"
            edvalues.setText(text)
            result(text)
        }
        btn4.setOnClickListener {
            val text = edvalues.text.toString()+"4"
            edvalues.setText(text)
            result(text)
        }
        btn5.setOnClickListener {
            val text = edvalues.text.toString()+"5"
            edvalues.setText(text)
            result(text)
        }
        btn6.setOnClickListener {
            val text = edvalues.text.toString()+"6"
            edvalues.setText(text)
            result(text)
        }
        btn7.setOnClickListener {
            val text = edvalues.text.toString()+"7"
            edvalues.setText(text)
            result(text)
        }
        btn8.setOnClickListener {
            val text = edvalues.text.toString()+"8"
            edvalues.setText(text)
            result(text)
        }
        btn9.setOnClickListener {
            val text = edvalues.text.toString()+"9"
            edvalues.setText(text)
            result(text)
        }
        btnmodulo.setOnClickListener {
            val text = edvalues.text.toString()+"%"
            edvalues.setText(text)
            result(text)
            check = check+1
        }
        btnadd.setOnClickListener {
            val text = edvalues.text.toString()+"+"
            edvalues.setText(text)
            result(text)
            check = check+1
        }
        btnsub.setOnClickListener {
            val text = edvalues.text.toString()+"-"
            edvalues.setText(text)
            result(text)
            check = check+1
        }
        btndiv.setOnClickListener {
            val text = edvalues.text.toString()+"/"
            edvalues.setText(text)
            result(text)
            check = check+1
        }
        btnmul.setOnClickListener {
            val text = edvalues.text.toString()+"*"
            edvalues.setText(text)
            result(text)
            check = check+1
        }

        btnequal.setOnClickListener {
            val text = edvalues.text.toString()
            edvalues.setText(text)
            tvresult.setText(null)
        }
        btnac.setOnClickListener {
            edvalues.setText(null)
            tvresult.setText(null)
        }

        btnbackspace.setOnClickListener {

            var backspace: String?=null
            if (edvalues.text.isNotEmpty()){
                val StringBuilder: StringBuilder = StringBuilder(edvalues.text)
                val find = edvalues.text.toString()
                val find2 = find.last()

                if (find2.equals('+') || find2.equals('-') || find2.equals('*') || find2.equals('/') || find2.equals('%')){

                    check = check-1
                }
                StringBuilder.deleteCharAt(edvalues.text.length-1)
                backspace = StringBuilder.toString()
                edvalues.setText(backspace)
                result(backspace)
            }
        }
    }

    private fun result(text: String) {

        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any=engine.eval(text)
            val main_result = result.toString()
            if(check==0){
                tvresult.setText(null)
            }
            else{
                tvresult.setText(main_result)
            }
        }
        catch (e: ScriptException){
            Log.d("d", "Error Message")
        }

    }
}
