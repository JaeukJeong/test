
import unittest
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC

#import pyautogui as pag
#from PIL import ImageGrab
url1 = "https://www.naver.com"
naver_id ="jjw3200"
naver_pw="K553524#&&@"


# 상품url
url2 = 'https://www.11st.co.kr/products/3855533901'

print('페이지 로딩중...')

chrome_options = webdriver.ChromeOptions()

prefs = {"profile.managed_default_content_settings.images": 2}
chrome_options.add_experimental_option("prefs", prefs)

# 크롬드라이버 다운로드 주소입니다.
driver = webdriver.Chrome("C:\python\chromedriver.exe", chrome_options=chrome_options)
# 로그인 페이지 로딩
driver.get(url1)

time.sleep(5)

driver.get(url1)

login_button = driver.find_element(by=By.CSS_SELECTOR, value="#account > a")
login_button.click()


#input_id = driver.find_element(by=By.CSS_SELECTOR, value="#id")
#input_pw = driver.find_element(by=By.CSS_SELECTOR, value="#pw")

driver.execute_script(f"document.getElementsByName('id')[0].value='{naver_id}'")
driver.execute_script(f"document.getElementsByName('pw')[0].value='{naver_pw}'")

#input_id.send_keys(naver_id)
#input_pw.send_keys(naver_pw)

driver.find_element(by=By.CSS_SELECTOR, value="#log\.login").click()

driver.get('https://brand.naver.com/samlip?NaPm=ct%3Dl2gv43pp%7Cci%3Dcheckout%7Ctr%3Dds%7Ctrx%3D%7Chk%3De28a4596a8cc562165e2ea776d61daba8e1520eb')


driver.find_element(by=By.CSS_SELECTOR, value="#pc-bestProductWidget > div > div > div > div > div > div:nth-child(1) > div > div > div:nth-child(1) > div > a").click()
                                               

#driver.find_element(by=By.CSS_SELECTOR, value="#pc-wholeProductWidget > div > div > div > div.EQjjFxgnKi._2_ISU3czu7 > div > div:nth-child(14) > div > a").click()

time.sleep(1)

try:

    while True:

        check = driver.find_element(by=By.CSS_SELECTOR, value="#content > div > div._2-I30XS1lA > div._2QCa6wHHPy > fieldset > div._2BQ-WF2QUb > strong")
        
        
                                                              
        
        #print(driver.find_element(by=By.CSS_SELECTOR, value="#content > div > div._2-I30XS1lA > div._2QCa6wHHPy > fieldset > div._2BQ-WF2QUb > strong").text)

        if check.text == '이 상품은 현재 구매하실 수 없는 상품입니다.':   # or check.text== '준비된 재고가 소진되어 품절되었습니다.재고 확보 후 다시 찾아뵙겠습니다.:
            driver.refresh()
            print("상품없음 새로고침진행...")
            driver.implicitly_wait(100)

        else:
        
            time.sleep(2)
        
            driver.find_element(by=By.CSS_SELECTOR, value="#content > div > div._2-I30XS1lA > div._2QCa6wHHPy > fieldset > div.XqRGHcrncz > div:nth-child(1) > div > a").click()
            break

except:
    time.sleep(2)
    driver.find_element(by=By.CSS_SELECTOR, value="#content > div > div._2-I30XS1lA > div._2QCa6wHHPy > fieldset > div.XqRGHcrncz > div:nth-child(1) > div > a").click()
        
time.sleep(2)  

driver.find_element(by=By.CSS_SELECTOR, value="#chargePointScrollArea > div.payment > ul.paymethod_list._paymentsArea > li.paymethod._payMethodTab._generalPaymentsTab > div.header > span.ajax_radio.radio-applied._payMethodRadio > span").click()

driver.find_element(by=By.CSS_SELECTOR, value="#chargePointScrollArea > div.payment > ul.paymethod_list._paymentsArea > li.paymethod._payMethodTab._generalPaymentsTab > ul > li.payment_item.tooltip_area > label").click()

div = driver.find_element(by=By.CLASS_NAME, value='btn_payment')
div.click()
