package com.example.wordhunter

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ModuleCardsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_cards)

        // Кнопка Назад
        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish() // Завершает текущую активность и возвращает на предыдущий экран
        }

        // Контейнер для карточек
        val cardsContainer: LinearLayout = findViewById(R.id.cardsContainer)

        // Данные для карточек
        val words = listOf(
            "Hello" to "Привет",
            "World" to "Мир",
            "Language" to "Язык",
            "Learning" to "Обучение",
            "Example" to "Пример"
        )

        // Создаем карточки и добавляем их в контейнер
        for (word in words) {
            val cardView = layoutInflater.inflate(R.layout.card_item, cardsContainer, false)
            val cardText = cardView.findViewById<TextView>(R.id.cardText)

            // Устанавливаем текст иностранного слова
            cardText.text = word.first

            // Обрабатываем нажатие на карточку
            cardText.setOnClickListener {
                if (cardText.text == word.first) {
                    cardText.text = word.second // Показываем перевод
                } else {
                    cardText.text = word.first // Возвращаем иностранное слово
                }
            }

            // Добавляем карточку в контейнер
            cardsContainer.addView(cardView)
        }
    }
}
