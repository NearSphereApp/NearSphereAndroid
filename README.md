# NearSphere



An Android application for discovering places, saving them as favorites, and managing user accounts. The project uses Retrofit for network requests, Data Binding for the UI, ViewModel + LiveData for architecture components, and EncryptedSharedPreferences for secure token storage.

---

## Table of Contents

1.  [Overview](#overview)
2.  [Project Structure](#project-structure)
    - [Model](#model)
    - [Repositories](#repositories)
    - [Service](#service)
    - [UI & Fragments](#ui-&-fragments)
3.	[Key Libraries & Technologies](#key-libraries--technologies)
4.	[Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation & Setup](#installation--setup)
5.	[Usage](#usage)
    - [Searching Places](#searching-places)
    - [Viewing & Adding Favorites](#viewing--adding-favorites)
    - [User Account & Authentication](#user-account--authentication)
6.	[API Endpoints](#api-endpoints)
7.	[Notes & Caveats](#notes--caveats)

## Overview

NearSphere is an app that allows users to:
- Search for nearby places based on keywords, location, and radius.
- Add places to their list of favorites.
- Create and manage their own user accounts (sign up, log in, reset password).

This project is structured to follow MVVM (Model-View-ViewModel) principles and uses **Retrofit** for asynchronous REST calls.


## Project Structure

The project is divided into several packages to maintain separation of concerns:

```
com.example.nearsphere
├─ model/
├─ repositories/
├─ service/
└─ ui/
    ├─ favourites/
    ├─ mainActivity/
    └─ user/
```
 - ### Model

#### Contains plain Java classes (POJOs) and data-binding classes: 
- **Favourites**: Represents a user’s favorite place (fields such as `displayName`, `formattedAddress`, etc.).
- **Places**: Holds data about each place (like `imgLinks`, `formattedAddress`, `priceLevel` etc.).
- **SearchParameters**: Encapsulates user-selected search criteria (`latitude`, `longitude`, `radius`, `keywords`).
- **User**: Represents the app user object.
- **UserRequest / UserResponse**: For handling login/signup requests and responses.
- **TokenStorage**: Manages the retrieval and storage of an auth token securely via EncryptedSharedPreferences.

- ### Repositories

#### Repositories handle data operations and network calls:
- **PlacesRepository**: Retrieves nearby places (using `PlacesAPIService`).
- **UserFavouriteRepository**: Manages the user’s favorite places (using `UserFavouritePlaceApiService`).
- **UserRepository**: Handles user login, signup, profile retrieval, etc. (using `UserAPIService`).

- ### Service

#### Defines the Retrofit interfaces and the `RetrofitInstance`:
- **RetrofitInstance**: Creates and configures the `Retrofit` object (logging interceptor, base URL, etc.).
- **PlacesAPIService**: Endpoints for fetching place data (GET requests for places).
- **UserAPIService**: Endpoints for user authentication and user operations (`login`, `signup`, `getUser`, etc.).
- **UserFavouritePlaceApiService**: Endpoints to manage user favorite places (`addFavourite`, `deleteFavourite`, etc.).

- ### UI & Fragments

Organized into different screens/features:
1.	**ui.mainActivity**
    -   **MainActivity**: The main entry point after login.
    - **HomeFragment**: Allows users to select keywords, location, and radius to search for places.
    - **PlacesFragment**: Displays a list of places matching the chosen criteria.
    - **Adapter**: Custom RecyclerView adapter for displaying places.
    - **Splash**: Splash screen that checks for a valid token and navigates accordingly.
2.	**ui.favourites**
    - **FavouritesFragment**: Displays the user’s saved favorite places.
    - **FavouritesAdapter**: RecyclerView adapter to show favorites.
    - **FavouritesViewModel**: ViewModel that fetches, adds, and deletes favorites via the repository.
3.	**user**
    - **LogActivity**: Screen for user login and initial entry.
    - **CreateLogFragment**: Embedded fragment that allows for new account registration.
    - **ResetPasswordFragment**: Initiates a password reset request.
    - **UserInfoFragment**: Displays and updates user info.
    - **PasswordEditFragment**: Screen for editing the user’s password.
## Key Libraries & Technologies
 - **Android Architecture Components**: ViewModel, LiveData
- **Data Binding**: For binding layouts directly to model classes.
 -  **Retrofit & OkHttp**: For RESTful API calls, logging, interceptors.
- **Gson**: JSON parsing.
- **EncryptedSharedPreferences** (in `TokenStorage`): Securely saves user tokens.
- **Google Places API**: Searching for or autocompleting places within the app.
## Getting Started

### Prerequisites
1.	**Android Studio** (latest version recommended).
2.	**Gradle** (handled by Android Studio).
3.	**A Google Places API Key** (if you want to expand or integrate actual Places data from Google).

### Installation & Setup
1. **Clone** the repo:

```
git clone https://github.com/<YourUsername>/LitsaAndroid.git
```
2.	**Open** the project in **Android Studio**.
3.	**Configure** the Google Places API key:
- In the AndroidManifest.xml (under `<application>`), set `<meta-data android:name="KEY" android:value="YOUR_API_KEY"/>` with your actual Google Places API Key, if you use the real Google service.
4.	**Sync** the project so that Gradle downloads all required dependencies.
5.	**Run** the application on an emulator or physical device.
## Usage

Below is a quick overview of the main flows in the app.

1. ### Searching Places
    1.	Launch the app. If you are not logged in, the **LogActivity** prompts for your credentials or sign up.
    2.	After logging in, the **HomeFragment** is displayed.
    3.	Enter an address or location, pick your search radius, and select relevant categories (check the boxes).
    4.	Tap **Submit** to fetch matching places.
    5.	The results show up in the **PlacesFragment** as a scrollable list.

2. ### Viewing & Adding Favorites
    1.	Each place card in the **PlacesFragment** has a floating action button (heart icon) to add or remove from favorites.
    2.	**FavouritesFragment** shows the user’s favorite places list. From here, you can see all saved items, and optionally remove them.

3. ### User Account & Authentication
    1.	**LogActivity** handles existing user login.
    2.	**CreateLogFragment** (accessible via the “Create account” button on the login screen) handles new account registration.
    3.	**ResetPasswordFragment** allows sending a password reset request if you forgot your credentials.
    4.	Once logged in, the **UserInfoFragment** (accessible from the bottom navigation “user” icon) displays user profile information.
    5.	Update or delete the user account as needed (though the final delete call may require an endpoint on your backend).
## API Endpoints

#### By default, this project points to `http://10.0.2.2:8080/api/v1/`  which can be changed in `RetrofitInstance.java`. The endpoints include:
- **Place**: `GET /place?latitude=&longitude=&radius=&keywords=` etc.
- **User**: `GET /user, POST /auth/login`, `POST /auth/signup`, `PATCH /user/{id}`, and so on.
- **Favourites**: `GET /favourites/{user_id}`, `POST /favourites/{user_id}`, `DELETE /favourites/{user_id}/{place_id}`.
## Notes & Caveats
- ### Token Management:
    - Tokens are stored in `TokenStorage` using `EncryptedSharedPreferences`.
    - Make sure your device or emulator meets the requirements for Android’s Security library.
- ### Error Handling:
    - By default, network/HTTP errors are logged with Log.e(...), and Toasts
    - You might want to implement better error-handling flows.
- ### Google Places API:
•	This app uses `com.google.android.libraries.places:places` and `AutocompleteSupportFragment` for address autocompletion.
•	If you do not provide a valid Google API key all location-based features may not work.
- ### Local Backend:
- At the IP `10.0.2.2:8080` is as a local server. Adjust the IP or domain as needed for your environment.
