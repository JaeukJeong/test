
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
url1 = "https://login.11st.co.kr/auth/front/login.tmall?returnURL=https%3A%2F%2Fwww.11st.co.kr%2F%3Fts%3D1650947124251"


# 상품url
url2 = 'https://www.11st.co.kr/products/3855533901'

#url2 = 'https://www.11st.co.kr/products/4041535732'

print('페이지 로딩중...')

chrome_options = webdriver.ChromeOptions()

prefs = {"profile.managed_default_content_settings.images": 2}
chrome_options.add_experimental_option("prefs", prefs)

# 크롬드라이버 다운로드 주소입니다.
driver = webdriver.Chrome("C:\python\chromedriver.exe", chrome_options=chrome_options)
# 로그인 페이지 로딩
#driver.get(url1)

time.sleep(5)

driver.get(url1)

driver.find_element(by=By.NAME, value='loginName').send_keys('jjw3200')
driver.find_element(by=By.NAME, value='passWord').send_keys('K553524377@')

login = driver.find_element(by=By.NAME, value='loginbutton')
login.click()

driver.get(url2)

time.sleep(2)

try:

    while True:

        check = driver.find_element(by=By.CSS_SELECTOR, value="#layBodyWrap > div > div.s_product.s_product_detail > div.l_product_cont_wrap > div > div.l_product_view_wrap > div.l_product_summary > div.l_product_side_info > div.b_product_info_price.b_product_info_price_style2 > p")

        if check.text == '현재 판매중인 상품이 아닙니다.' or check.text == '현재 주문 폭주로 구매가 어렵습니다.':
            driver.refresh()
            print("상품없음 새로고침진행...")
            driver.implicitly_wait(100)

        else:
            time.sleep(1)
            div = driver.find_element(by=By.CLASS_NAME, value='btn_buying')
            div.click()
            break

except:
    time.sleep(1)
    div = driver.find_element(by=By.CLASS_NAME, value='btn_buying')
    div.click()
    
        
time.sleep(2)    


#div = driver.find_element(by=By.CLASS_NAME, value='btn_buying')
#div.click()

time.sleep(1)

print("일반결제...")
radio = WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.XPATH, "//input[@id='payOthers']/following::span[1]")))
driver.execute_script("arguments[0].click();", radio)
noaccount_table = driver.find_element_by_id("paymentGeneralTab5")
print("무통장입금 선택")
noaccount_table.click()
bankKindCtl = driver.find_element_by_id("bankKindCtl04")
bankKindCtl.click()
buying = driver.find_element_by_class_name("btn_order")

buying.click()
print("주문이 완료되었습니다.")
