package com.lopez.rosa.laboratoriocalificado03

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lopez.rosa.laboratoriocalificado03.databinding.ItemTeacherBinding

class TeacherAdapter(
    private val context: Context,
    private val teachers: List<Teacher>
) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    inner class TeacherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemTeacherBinding.bind(view)

        fun bind(teacher: Teacher) {
            binding.tvName.text = teacher.name
            binding.tvLastName.text = teacher.lastName
            binding.tvPhone.text = teacher.phoneNumber
            binding.tvEmail.text = teacher.email

            Glide.with(context)
                .load(teacher.imageUrl)
                .error(android.R.drawable.ic_menu_report_image) // Imagen de respaldo
                .into(binding.imgTeacher)

            binding.root.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${teacher.phoneNumber}"))
                context.startActivity(intent)
            }

            binding.root.setOnLongClickListener {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:${teacher.email}")
                }
                context.startActivity(intent)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_teacher, parent, false)
        return TeacherViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        holder.bind(teachers[position])
    }

    override fun getItemCount(): Int = teachers.size
}
