package com.example.listacontactos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ContactosAdapter(private val contactos: List<Contacto>) :
    RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreView: TextView = itemView.findViewById(R.id.tvNombre)
        val telefonoView: TextView = itemView.findViewById(R.id.tvTelefono)
        val ivImagen: ImageView = itemView.findViewById(R.id.ivImagen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacto, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int{
        return contactos.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contactos[position]
        if (contact.imagen == 1){
            holder.ivImagen.setImageResource(R.drawable.fmale)
        }
        else{
            holder.ivImagen.setImageResource(R.drawable._29466_man_512x512)
        }

        holder.nombreView.text = contact.nombre
        holder.telefonoView.text = contact.telefono
    }

}