package my.edu.tarc.myepf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import my.edu.tarc.myepf.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var investment: Investment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
           this, R.layout.activity_main
        )

        binding.buttonCalculate.setOnClickListener{
            val age = binding.spinnerAge.selectedItemPosition
            if(binding.editTextNumberDecimal.text.toString().isEmpty()){
                binding.editTextNumberDecimal.setError("Value required")
                return@setOnClickListener
            }

            val account_balance = binding.editTextNumberDecimal.text.toString().toFloat()
            var amount: Float = 0.0f
            if(account_balance < 5000){
                binding.editTextNumberDecimal.setError("Your account balance should be more than 5000!")
                return@setOnClickListener
            }
            when(age){
                0->
                    amount = (account_balance - 5000) * 0.3f
                1->
                    amount = (account_balance - 14000 ) * 0.3f
                2->
                    amount = (account_balance - 29000 ) * 0.3f
                3->
                    amount = (account_balance - 50000 ) * 0.3f
                4->
                    amount = (account_balance - 78000 ) * 0.3f
                5->
                    amount = (account_balance - 116000 ) * 0.3f
                6->
                    amount = (account_balance - 165000 ) * 0.3f
                7->
                    amount = (account_balance - 228000 ) * 0.3f
                else->
                    amount = 0.0f
            }


            investment = Investment(amount.toString())
            binding.myInvest = investment
        }

        binding.buttonReset.setOnClickListener{
            binding.myInvest = Investment("0.00")
        }


    }
}