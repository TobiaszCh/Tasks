call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo runcrud.bat has errors
goto fail

:browser
start chrome "http://localhost:8080/crud/v1/task/tasks"
start chrome "https://www.google.pl/"
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.