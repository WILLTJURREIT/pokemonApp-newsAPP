# 🧪 PokémonApp – Project Documentation   **(Approx- 90-HOURS Invested)**

## 📌 Important Notes & Background

### 🔧 Challenges & Key Milestones

1. **Early Gradle Issues**
    At the start of Coding Assignments 1 and 2, I spent a significant amount of time learning how to resolve Gradle configuration issues in Android Studio. This slowed down my initial development progress.
   
2. **Original Plan: Coin Clicker App**
    I initially worked on a **Coin Clicker App** and had completed roughly 75% of it, which would have accounted for Coding Assignments 2 & 3.
   
3. **Project Loss & Studio Crash** 
   Unfortunately, my project was lost due to a crash in Android Studio. I mistakenly deleted a critical Gradle file while troubleshooting, which caused the project to become unrecoverable. I reached out to my instructor for support, and he was very understanding and flexible.
   
4. **Backup Plan: Modify the NewsApp**
   Due to time constraints and workload from other courses, I planned to modify the **NewsApp tutorial project** to meet the assignment requirements while making it functionally and visually different.
   
5. **API Limitations** 
   I began by changing layout colors and API data within the NewsApp. However, I discovered that the default API did not support switching between countries as I had hoped.
   
6. **Final Pivot: Pokémon API Integration** 
   Inspired by my instructor’s use of a **Pokémon API**, I decided to pivot to a new idea and integrate this API instead. This change came very late in the term but felt achievable given the simplicity of the Pokémon data structure.

7. **Recovery Strategy**
   Given my previous setbacks with Android Studio, I focused on building a version of the app that would be stable, functional, and well-scoped for the assignment requirements.

---  let bigBox = [apple, orange, banana];

const table = document.getElementById('scoped').innerText;

if (table == 1) {
  bigBox[1];
  table.document.write('bigBox').innerText;
}

### Progress Summary – Key Technical Efforts

- Customized the app’s appearance by editing `themes.xml` and `colors.xml`.
- Changed the font from **Poppins Regular** to **Alexandria** to enhance the visual style.
- Encountered consistent Android Studio rebuild issues, often requiring:
  - Cleaning and rebuilding the project
  - Invalidating caches and restarting
  - Deleting the `/build` folder manually
  - Restarting Android Studio and, at times, the entire system
- Manually updated variable names and file references to align with the Pokémon theme.
- Replaced the **Headlines** icon to better suit the new context; retained the **heart** and **search** icons due to their continued relevance.
- Confirmed that both JSON and Kotlin plugins were correctly included in `build.gradle.kts`.
- Attempted to modify the News API by changing the `countryCode` to explore content from other regions.
- Determined, after testing and meeting with the instructor, that the API only returns results for the USA.
- Pivoted to using the PokéAPI to implement a more engaging and technically diverse data source.
- Faced structural challenges due to differences between the News API and PokéAPI, including:
  - Data model adjustments
  - New endpoint structures
  - Conflicting logic and naming conventions
- Addressed problems that arose from overlapping old NewsApp code with new Pokémon-based logic and research.
- Maintained core Android architecture throughout the transition:
  - Used Room database for storing favorites
  - Connected UI and data with ViewModel
  - Rendered data lists using RecyclerView

---

## 📚 What I Learned

1. **Error Reading Is Key**Carefully reading each error message—line by line—was one of the most valuable lessons. It helped me understand where problems were happening and how to fix them methodically.
2. **Build Process Awareness**I learned how important it is to understand the build process of Android apps. Knowing when and why to clean, rebuild, or restart the IDE helped me navigate difficult development moments.
3. **Adaptability in Development**Being flexible and pivoting between project ideas (Coin Clicker → NewsApp → PokémonApp) was a challenging but important skill. In a real-world scenario, adapting to issues and deadlines is essential.
4. **Importance of Backups**Losing a project due to a crash taught me the importance of version control and frequent backups. I now plan to use Git consistently for future projects.
5. I have more to add here...

---

# 📱 Pokémon Android App – Project Structure & Explanation

This Section outlines the structure and purpose of each file in my Pokémon app, it explains how it is aligned with my assignment requirements. Room, RecyclerView, Fragments, ViewModel, LiveData, and more.

---

## 🗂️ Folder-by-Folder Breakdown of the Pokemon App So far.

📚 Note: During the development process, I reached a point where it became necessary to remove the remaining files from the original NewsApp structure. After closely analyzing and mirroring its design and architecture, I determined that fully removing the parallel NewsApp components would help minimize potential conflicts and simplify debugging efforts moving forward.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### `api/` – *Handles the Pokémon API (Retrofit)*

**`PokemonApiService.kt`**
  ➤ This Defines API endpoints using Retrofit to fetch data from PokéAPI.

**`RetrofitClient.kt`**
  ➤ Builds the Retrofit instance shared throughout the app.

✅ **Aligned with Assignment Criteria**: External API usage, supports ViewModel and Repository.

---

### `db/` – *Room Database (for favorites)*

**`FavoritePokemon.kt`**
  ➤ Data entity for a favorite Pokémon.

**`FavoritePokemonDAO.kt`**
  ➤ DAO interface with Room queries (insert, getAll).

**`PokemonDatabase.kt`**
  ➤ Room database holder, includes DAO references.

**`Converters.kt`**
  ➤ Type converters for Room (e.g. list to string).

**`PokemonDAO.kt`, `AppDataClass.kt`, `MyType.kt`**
  ➤ Additional Room entities/DAOs (I may or may not need these, but I will leave them for now).

✅ **Aligned with Assignment Criteria**: Room persistence, LiveData, ViewModel integration.

---

### `models/` – *Data models from the API*

**`Pokemon.kt`**
  ➤ Represents a Pokémon object.

**`PokemonResponse.kt`**
  ➤ The top-level JSON wrapper for the Pokémon API response.

✅ **Aligned with Assignment Criteria**: Models external data structure.

---

### `repository/` – *Connects UI and data*

**`PokemonRepository.kt`**
  ➤ Repository layer that interacts with both Room and API, used by ViewModel.

✅ **Aligned with Assignment Criteria**: MVVM architecture, LiveData source.

---

### `ui/` – *User Interface Components*

#### `adapter/`

**`PokemonAdapter.kt`**, **`PokemonViewHolder.kt`**
  ➤ Binds Pokémon list data to the RecyclerView.

#### `fragments/`

**`PokemonFragment.kt`**
  ➤ Displays the Pokémon list from the API.

**`FavoritesFragment.kt`**
  ➤ Shows a list of favorited Pokémon from Room.

**`SearchFragment.kt`**
  ➤ Allows the user to search Pokémon (in the local API).

#### Main Activity

**`PokemonActivity.kt`**
  ➤ Hosts fragments and navigation.

✅ **Aligned with Assignment Criteria**: Fragments, RecyclerView, ViewBinding, and potentially Intents.

---

### `viewmodels/` – *Holds app logic and state*

**`PokemonViewModel.kt`**
  ➤ Connects the repository to UI using LiveData.

**`PokemonViewModelFactory.kt`**
  ➤ Factory for ViewModel injection with dependencies.

✅ **Aligned with Assignment Criteria**: ViewModel + LiveData + (optionally) two-way binding.

---

### `utils/` – *Shared helpers/constants*

**`Constants.kt`**
  ➤ Holds constant values like API base URL.

**`Resource.kt`**
  ➤ Wrapper class to represent Loading/Success/Error states.

✅ **Aligned with Assignment Criteria**: Clean architecture support, not directly required.

---

### `res/` – *XML Layouts, Menus, Drawables*

#### `layout/`

**`activity_pokemon.xml`**, **fragment_*.xml**, **item_*.xml**
  ➤ Layouts for activity, fragments, and RecyclerView items.

#### `drawable/`

Icons like hearts, search, launcher background, etc.

#### `menu/`

**`bottom_navigation_menu.xml`**
  ➤ Menu for BottomNavigationView.

#### `navigation/`

**`pokemon_nav_graph.xml`**
  ➤ Navigation graph for fragment transitions.

#### `values/`

**`strings.xml`**, **`colors.xml`**, **`themes.xml`**
  ➤ App-wide configurations for localization, styling, and theming.

✅ **Aligned with Assignment Criteria**: Usable UI, theme support, portrait & landscape design.

---

### `AndroidManifest.xml`

- Declares app components, permissions, and sets the main activity.

---

### `build.gradle.kts` (Project & App)

- Dependency management and build configuration.

---

> *The app uses MVVM architecture because it separates by using a ViewModel to expose LiveData from a Repository to the UI, which is a core principle of MVVM.*

> *This layout follows MVVM architecture and implements all required Android components for your assignment.*

---

🔗 **Resources used to understand key Topics Used in the App**

### 1. [API Integration with Retrofit](https://square.github.io/retrofit/)

Retrofit: A Type-safe HTTP Client for Android and Java

### 2. [MVVM Architecture (Model-View-ViewModel)](https://developer.android.com/topic/architecture#recommended-app-arch)

Guide to App Architecture Android Developers

### 3. [Room Database with DAO](https://developer.android.com/training/data-storage/room)

Save data using Room – Android Developers

### 4. [LiveData and ViewModel](https://developer.android.com/topic/libraries/architecture/livedata)

LiveData Overview – Android Developers

### 5. [RecyclerView for List Displays](https://developer.android.com/guide/topics/ui/layout/recyclerview)

RecyclerView – Android Developers

### 6. [Navigation Component (Fragments + Navigation Graph)](https://developer.android.com/guide/navigation)

Navigation Component – Android Developers
------------------------------------------

### **Images:**
URL:https://pokeapi.co/api/v2/pokemon?limit=10&offset=0

![POKEAPI](Pokeapi.png)
This accesses the pokemon endpoint and returns a paginated list of Pokémon with these parameters:

**Parameter	Description**
limit=10	Limits the number of Pokémon results returned to 10
offset=0	Starts the list at the first Pokémon (offset 0 = start)

---


## 🎥 **YouTube References**

### 1. Retrofit Integration in Android

**Title:** [Getting Started with Retrofit | Android Studio | Java](https://www.youtube.com/watch?v=lz5lPAdA3fQ)
**Description:** This tutorial introduces Retrofit for making API requests in Android. It's perfect for learning how to fetch data from APIs like the PokéAPI.

---

### 2. Room Database with MVVM Architecture

**Title:** [The Beginner Guide for Room in Android](https://www.youtube.com/watch?v=bOd3wO0uFr8)
**Description:** A complete walkthrough on implementing Room with MVVM. It covers setting up the database, entities, DAOs, and connecting it to a ViewModel—exactly what’s used in your app for managing favorite Pokémon.

---


## 🚧 Next Steps

- Fine tune the app and debug the issues to get it functioning.
- double check that the UI is how I would like it, make any alterations as needed.
- Make sure the app runs correctly in all cases.
- If there is a need for any additional buttons, or fragments, add them to the app.
- More to fill in here...

📌 *Note on AI Assistance*
Note:
I am currently overdue at the time of writing this documentation, and I would like to acknowledge that AI (ChatGPT) has been a tool I’ve used to assist with troubleshooting and problem-solving throughout this project.

Due to the challenges I've faced and the high stakes of the assignment, I found it necessary to utilize this resource to help me understand and resolve issues that arose during development. However, I want to emphasize that I am not relying on AI for direct copy-pasting of code, but rather using it to explain problems, understand error messages, and clarify concepts that I may have struggled to grasp on my own.

This note is intended to ensure transparency about my usage of AI as a learning aid in the context of this project.
-------------------------------------------------------------------------------------------------------------------

> 💡 *This project represents my ability to problem-solve, adapt quickly, and work within technical limitations to meet assignment goals.*
> I'm proud of the progress made given the setbacks and time constraints.
