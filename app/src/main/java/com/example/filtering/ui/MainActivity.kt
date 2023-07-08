package com.example.filtering.ui


import android.os.Bundle
import android.text.Editable
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filtering.R
import com.example.filtering.adapter.StudentAdapter
import com.example.filtering.databinding.ActivityMainBinding
import com.example.filtering.model.Student


class MainActivity : AppCompatActivity() {

    private var studentList: ArrayList<Student> = ArrayList()
    private var filteredStudentList: ArrayList<Student> = ArrayList()
    private lateinit var binding: ActivityMainBinding
    private var studentAdapter: StudentAdapter? = null
    private lateinit var spinnerAdapter: ArrayAdapter<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        addStudentsToList()
        setSpinnerAdapter()
        setListeners()
    }

    private fun setListeners() {
        binding.etFilter.addTextChangedListener { text ->
            when (binding.spinner.selectedItem.toString()) {
                "İsim" -> {
                    if (text.toString().isEmpty()) {
                        setAdapter(studentList)
                    } else {
                        filteredStudentList = studentList.filter { student ->
                            student.name.lowercase().contains(text.toString().lowercase())
                        } as ArrayList<Student>
                        setAdapter(filteredStudentList)
                    }
                }
                "Numara" -> {
                    if (text.toString().isEmpty()) {
                        setAdapter(studentList)
                    } else {
                        filteredStudentList = studentList.filter { student ->
                            student.number.lowercase().contains(text.toString().lowercase())
                        } as ArrayList<Student>
                        setAdapter(filteredStudentList)
                    }
                }
                "Not" -> {
                    if (text.toString().isEmpty()) {
                        setAdapter(studentList)
                    } else {
                        filteredStudentList = studentList.filter { student ->
                            student.note.lowercase().contains(text.toString().lowercase())
                        } as ArrayList<Student>
                        setAdapter(filteredStudentList)
                    }
                }
                "Harf Notu" -> {
                    if (text.toString().isEmpty()) {
                        setAdapter(studentList)
                    } else {
                        filteredStudentList = studentList.filter { student ->
                            student.letterGrade.lowercase().contains(text.toString().lowercase())
                        } as ArrayList<Student>
                        setAdapter(filteredStudentList)
                    }
                }
            }

        }
    }

    private fun addStudentsToList() {
        studentList.add(Student("Yusuf Aydın", "2180656027", "100", "AA"))
        studentList.add(Student("Umut Güler", "2180656051", "85", "BA"))
        studentList.add(Student("Kağan Çoşar", "2180656063", "75", "BB"))
        studentList.add(Student("Mahmut Kurnaz", "2180656033", "60", "CC"))
        studentList.add(Student("Fatma Peker", "2180656044", "100", "AA"))
        studentList.add(Student("Davut Çoban", "2180656032", "80", "BA"))
        studentList.add(Student("Ogün Şahin", "2180656060", "70", "BB"))
        studentList.add(Student("Muhammet Soydaş", "2180656021", "65", "CC"))
        setAdapter(studentList)
    }

    private fun setAdapter(list: ArrayList<Student>) {
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        studentAdapter = StudentAdapter(list)
        binding.rvMain.adapter = studentAdapter
    }

    private fun setSpinnerAdapter() {
        spinnerAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.student_features,
            android.R.layout.simple_spinner_item
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        binding.spinner.adapter = spinnerAdapter
    }

    private fun filter(filterString: Editable, feature : Any) {
        if (filterString.toString().isEmpty()) {
            setAdapter(studentList)
        } else {
            filteredStudentList = studentList.filter { listItem ->
                listItem.name.lowercase().contains(filterString.toString().lowercase())
            } as ArrayList<Student>
            setAdapter(filteredStudentList)
        }
    }


}

