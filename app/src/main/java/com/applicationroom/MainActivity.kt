package com.applicationroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.applicationroom.adapters.ShowAdapter
import com.applicationroom.database.User
import com.applicationroom.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var showRV: RecyclerView


    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        showRV = binding.rvShowInfo

        // on below line we are initializing our adapter class.
        val showRVAdapter = ShowAdapter(this)

        // on below line we are setting
        // adapter to our recycler view.
        showRV.adapter = showRVAdapter




        binding.btSave.setOnClickListener {

            val userName = binding.etInfoToSave.text.toString()

            if(userName.isNotEmpty()){
                mainViewModel.saveUser(User(
                    "numeroid3",
                    "$userName",
                    1.71,
                    71.1,
                    "user002@email.com",
                    "passworduser0002"))
                Toast.makeText(this, "user Added", Toast.LENGTH_LONG).show()

                val intent = Intent(this@MainActivity, MainActivity::class.java)
                startActivity(intent)
                this.finish()

            }

        }



        mainViewModel.getUsers()

        var fakeVideoData: Array<JSONObject>

        fakeVideoData = arrayOf(
            JSONObject("{\"user\": \"hola\"}"),
        )
        //si es fragment
        //es con viewLifecycleOwner en lugar de this
        mainViewModel.savedUsers.observe(this,{usersList ->


            if(!usersList.isNullOrEmpty()){
                // on below line we are updating our list.
                showRVAdapter.updateList(usersList)
                for(user in usersList){
                    Log.d("thesearetheusers",user.user_name)



                }
            }else{
                Log.d("thesearetheusers","null or empty")
            }
        })





    }
}

/* // on below line we are initializing
        // all our variables.
        notesRV = binding.notesRV
        addFAB = binding.idFAB

        // on below line we are setting layout
        // manager to our recycler view.
        notesRV.layoutManager = LinearLayoutManager(this)

        // on below line we are initializing our adapter class.
        val noteRVAdapter = NoteRVAdapter(this, this, this)

        // on below line we are setting
        // adapter to our recycler view.
        notesRV.adapter = noteRVAdapter

        // on below line we are
        // initializing our view modal.
        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModal::class.java)

        // on below line we are calling all notes method
        // from our view modal class to observer the changes on list.
        viewModal.allNotes.observe(this, Observer { list ->
            list?.let {
                // on below line we are updating our list.
                noteRVAdapter.updateList(it)
            }
        })*/