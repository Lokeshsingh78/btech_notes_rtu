package com.example.btechrtu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView.setNavigationItemSelectedListener(this)

        // Set up button click listeners
        findViewById<Button>(R.id.button1).setOnClickListener {
            startActivity(Intent(this@MainActivity, Semester1Activity::class.java))
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            startActivity(Intent(this@MainActivity, Semester2Activity::class.java))
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            startActivity(Intent(this@MainActivity, Semester3Activity::class.java))
        }

        findViewById<Button>(R.id.button4).setOnClickListener {
            startActivity(Intent(this@MainActivity, Semester4Activity::class.java))
        }

        findViewById<Button>(R.id.button5).setOnClickListener {
            startActivity(Intent(this@MainActivity, Semester5Activity::class.java))
        }

        findViewById<Button>(R.id.button6).setOnClickListener {
            startActivity(Intent(this@MainActivity, Semester6Activity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.drawer_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else when (item.itemId) {
            R.id.nav_semester1, R.id.nav_semester2, R.id.nav_semester3, R.id.nav_semester4, R.id.nav_semester5, R.id.nav_semester6 -> {
                handleSemesterMenuClick(item.itemId)
                true
            }
            R.id.nav_telegram, R.id.nav_instagram -> {
                handleContactDeveloperMenuClick(item.itemId)
                true
            }
            R.id.action_contribute -> {
                openEmailClient()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun handleSemesterMenuClick(itemId: Int) {
        val activityClass = when (itemId) {
            R.id.nav_semester1 -> Semester1Activity::class.java
            R.id.nav_semester2 -> Semester2Activity::class.java
            R.id.nav_semester3 -> Semester3Activity::class.java
            R.id.nav_semester4 -> Semester4Activity::class.java
            R.id.nav_semester5 -> Semester5Activity::class.java
            R.id.nav_semester6 -> Semester6Activity::class.java
            else -> null
        }
        activityClass?.let {
            startActivity(Intent(this, it))
        }
    }

    private fun handleContactDeveloperMenuClick(itemId: Int) {
        val url = when (itemId) {
            R.id.nav_telegram -> "https://t.me/Lokeshsingh123"
            R.id.nav_instagram -> "https://www.instagram.com/_lokesh___3983"
            else -> null
        }
        url?.let {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
            startActivity(intent)
        }
    }

    private fun openEmailClient() {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // Only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, arrayOf("lokeshsinghtanwar78@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, "Contribute to BTech Notes")
            putExtra(Intent.EXTRA_TEXT, "Hi, I would like to contribute the following course notes...")
        }

        if (emailIntent.resolveActivity(packageManager) != null) {
            startActivity(emailIntent)
        } else {
            // Handle the case where no email app is available
            ContextCompat.startActivity(this, Intent.createChooser(emailIntent, "Choose an email client"), null)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_semester1 -> startActivity(Intent(this, Semester1Activity::class.java))
            R.id.nav_semester2 -> startActivity(Intent(this, Semester2Activity::class.java))
            R.id.nav_semester3 -> startActivity(Intent(this, Semester3Activity::class.java))
            R.id.nav_semester4 -> startActivity(Intent(this, Semester4Activity::class.java))
            R.id.nav_semester5 -> startActivity(Intent(this, Semester5Activity::class.java))
            R.id.nav_semester6 -> startActivity(Intent(this, Semester6Activity::class.java))

            R.id.nav_telegram -> {
                val telegramUsername = "https://t.me/Lokeshsingh123"
                val telegramIntent = Intent(Intent.ACTION_VIEW, Uri.parse(telegramUsername))
                startActivity(telegramIntent)
            }
            R.id.nav_instagram -> {
                val instagramUsername = "https://www.instagram.com/_lokesh___3983"
                val instagramIntent = Intent(Intent.ACTION_VIEW, Uri.parse(instagramUsername))
                startActivity(instagramIntent)
            }
        }
        drawerLayout.closeDrawers()
        return true
    }
}
