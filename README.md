# console_crud_app
Необходимо реализовать консольное CRUD приложение, которое имеет следующие сущности:

Student Subject StudentAccount AccountStatus (enum PRIMARY, SECONDARY, GRADUATE)

Student-> Set subjects + StudentAccount account Account -> AccountStatus

В качестве хранилища данных необходимо использовать текстовые файлы: students.txt, subjects.txt, accounts.txt

Пользователь в консоли должен иметь возможность создания, получения, редактирования и удаления данных.

Слои: model - POJO клаcсы repository - классы, реализующие доступ к текстовым файлам controller - обработка запросов от пользователя view - все данные, необходимые для работы с консолью

Например: Subject, SubjectRepository, SubjectController, SubjectView и т.д.

Для репозиторного слоя желательно использовать базовый интерфейс: interface GenericRepository<T,ID>

interface SubjectRepository extends GenericRepository<Subject, Long>

class JavaIOSubjectRepositoryImpl implements SubjectRepository

Результатом выполнения задания должен быть отдельный репозиторий с README.md файлом, который содержит описание задачи, проекта и инструкции запуска приложения через командную строку.
