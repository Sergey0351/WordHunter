package com.example.wordhunter

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button

// Адаптер для списка
class ModuleAdapter(
    context: Context,            // Контекст
    private val resource: Int,   // Ресурс макета для каждого элемента
    private val modules: List<String> // Список данных (названия модулей)
) : ArrayAdapter<String>(context, resource, modules) {

    // Перегружаем метод getView для кастомизации отображения элементов списка
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Проверяем, если convertView == null, то инфлейтим новый элемент
        val view: View = convertView ?: LayoutInflater.from(context).inflate(resource, parent, false)

        // Находим кнопку в макете
        val button: Button = view.findViewById(R.id.module_button)

        // Устанавливаем текст кнопки
        button.text = modules[position]

        // Обработка нажатия на кнопку
        button.setOnClickListener {
            // Например, выводим Toast сообщение
            // Можно заменить на логику для перехода между экранами
            Toast.makeText(context, "Нажат: ${modules[position]}", Toast.LENGTH_SHORT).show()

            // Тут можно добавить код для перехода на другие экраны или действия
            when (position) {
                0 -> {
                    // Действие для первого модуля
                }
                1 -> {
                    // Действие для второго модуля
                }
                2 -> {
                    // Действие для третьего модуля
                }
            }
        }

        // Возвращаем view для текущего элемента
        return view
    }
}
