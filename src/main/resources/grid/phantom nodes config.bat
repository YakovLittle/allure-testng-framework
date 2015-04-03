@echo off
timeout /T 25
for /L %%a in (5001,1,5002) do (
   start cmd /C C:\Driver\phantomjs.exe --webdriver=127.0.0.1:%%a --webdriver-selenium-grid-hub=http://127.0.0.1:4441/grid/register --disk-cache=false
   timeout /T 1
)