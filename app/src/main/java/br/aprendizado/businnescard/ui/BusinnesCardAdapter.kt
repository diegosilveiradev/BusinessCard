package br.aprendizado.businnescard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.aprendizado.businnescard.data.BusinnesCard
import br.aprendizado.businnescard.databinding.ItensBusinnesCardBinding

class BusinnesCardAdapter :
    ListAdapter<BusinnesCard, BusinnesCardAdapter.ViewHolder>(DiffCallBack()) {

    var listenerShare: (View) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItensBusinnesCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItensBusinnesCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BusinnesCard) {
            binding.tvNome.text = item.nome
            binding.tvEmail.text = item.email
            binding.tvTelefone.text = item.telefone
            binding.tvNomeEmpresa.text = item.empresa
            binding.mcvContent.setBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.mcvContent.setOnClickListener {
                listenerShare(it)
            }
        }
    }


}

class DiffCallBack : DiffUtil.ItemCallback<BusinnesCard>() {
    override fun areItemsTheSame(oldItem: BusinnesCard, newItem: BusinnesCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinnesCard, newItem: BusinnesCard) =
        oldItem.id == newItem.id


}