package com.example.filtering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filtering.databinding.ItemMainBinding
import com.example.filtering.model.Student

class StudentAdapter(private val studentList : ArrayList<Student>) : RecyclerView.Adapter<StudentAdapter.StudentHolder>() {

    class StudentHolder(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StudentHolder(binding)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        holder.binding.tvName.text = studentList[position].name
        holder.binding.tvStudentNumber.text = studentList[position].number
        holder.binding.tvNote.text = studentList[position].note
        holder.binding.tvLetterGrade.text = studentList[position].letterGrade
    }
}