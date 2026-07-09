# Android Automation Framework - Development Rules

## Project Goal

Build a professional Android automation framework using Accessibility Service, overlay controls, gesture execution, macro scheduling, and persistent user configuration.

The first product feature is an Auto Clicker.

## Tech Stack

- Language: Kotlin only
- UI: Jetpack Compose only
- Theme: Material 3
- Build: Gradle Kotlin DSL
- Min SDK: 24
- JDK: 21
- Architecture: MVVM with clean separation of UI, domain, data, and service layers
- Async: Kotlin Coroutines, Flow, StateFlow
- Dependency Injection: Hilt
- Persistence: Room and DataStore
- Testing: JUnit, kotlinx-coroutines-test, MockK where needed

## General Rules

- Do not use XML UI.
- Do not use deprecated Android APIs.
- Do not use GlobalScope.
- Do not use Thread directly unless there is a strong reason.
- Prefer structured concurrency.
- Prefer immutable UI state.
- Use sealed interfaces/classes for UI events and domain results where useful.
- Keep business logic outside Composables.
- Keep Android framework dependencies out of domain layer.
- Add KDoc for public classes and non-trivial functions.
- Add tests for core logic.
- Keep code readable and production-oriented.

## Compose Rules

- Composables must be stateless where practical.
- Screen state must come from ViewModel.
- Use Material 3 components.
- Avoid putting business logic inside Composables.
- Use preview functions for important screens.

## Coroutine Rules

- Use viewModelScope for ViewModels.
- Use service scope for long-running Android services.
- Handle cancellation correctly.
- Do not swallow CancellationException.
- Prefer StateFlow for UI state.
- Prefer SharedFlow or Channel for one-time events when appropriate.

## Accessibility Rules

- Accessibility Service must be isolated in a dedicated package.
- Gesture execution must be abstracted behind a domain/service interface.
- User must explicitly enable Accessibility Service.
- Do not automate sensitive flows like banking, payments, login bypass, or security-critical screens.
- Add clear user-facing explanation for why Accessibility permission is needed.

## Overlay Rules

- Overlay code must be isolated in a dedicated package.
- Overlay permission must be requested explicitly.
- Overlay lifecycle must be controlled to avoid WindowManager leaks.
- Always remove overlay views when service stops.

## Git Rules

- Work in small commits.
- One feature per branch.
- Commit messages should be clear and specific.
- Do not commit local.properties, build outputs, or IDE/cache files.