package com.example.wordhunter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Подключаем макет для фрагмента
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Список модулей
        val modules = listOf("Модуль 1", "Модуль 2", "Модуль 3")

        // Получаем ссылку на ListView
        val modulesListView: ListView = view.findViewById(R.id.modulesListView)

        // Создаем адаптер и устанавливаем его для ListView
        val adapter = ModuleAdapter(requireContext(), R.layout.item_module, modules)
        modulesListView.adapter = adapter
    }
}
