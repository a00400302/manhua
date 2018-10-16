import io
import sys
import requests
from bs4 import BeautifulSoup
from selenium import webdriver
import time
import threading
import _mysql
sys.stdout = io.TextIOWrapper(sys.stdout.buffer,encoding='utf8')
from selenium.webdriver.chrome.options import Options

chrome_options = Options()
chrome_options.add_argument('--headless')
chrome_options.add_argument('--disable-gpu')








# 漫画info ->  集数 ->  页面
def img(b,driver,iid,db):
    spans = b.find_all("span",attrs={"class":"works-chapter-item"})
    pagecount = len(spans)
    for item in range(0,5):
        if item < pagecount:
            itemspan = spans[item]
            # 集数的标题
            itemtitle = itemspan.a['title'] 
            db.query("""insert into manhuacount(iid,title) values(\'%d\',\'%s\')""" %(iid,itemtitle))
            driver.get("http://ac.qq.com"+itemspan.a['href'])
           
            for i in range(1000,115000,2150):
                jsCode = "window.scrollTo(0,\'%d\')" %(i)
                driver.execute_script(jsCode)
                time.sleep(0.25)       
            for img in driver.find_element_by_class_name("comic-contain").find_elements_by_css_selector("li > img"):
                imgurl = img.get_attribute("src")
                db.query("""select id from manhuacount where iid=\'%d\'""" %iid)
                cid = int(db.store_result().fetch_row()[0][0])
                db.query("""insert into manhuaimg(cid,imgurl)  values(\'%d\',\'%s\')""" %(cid,imgurl))


def manhua(li):
    for manhua in li:
        div  =manhua.find_all('div')
        # 标题缩略图
        titleimage = div[0].a.img['data-original']
        # 标题
        titlename = div[1].h3.a['title']

        # 类型
        manhuatype =  div[1].find_all('p')[1].a
        if manhuatype == None:
            manhuatype = "爆笑"
        else:
            manhuatype = manhuatype.string

        # 简介
        manhuainfo = div[1].find_all('p')[2].string
        # 作者
        manhuaauthor = div[1].p.string

        db=_mysql.connect("localhost","root","123456","manhua")
        db.set_character_set("utf8")
        db.query("insert into manhuainfo(img,name,type,info,author) values(\'" + titleimage + "\',\'%s\',\'%s\',\'%s\',\'%s\')" %(titlename,manhuatype,manhuainfo,manhuaauthor))        
        db.commit()

        db.query("""select id from  manhuainfo where name=\'%s\'""" %titlename)
        iid = int(db.store_result().fetch_row()[0][0])
        inurl  = "http://ac.qq.com"+div[1].a['href']
        manhuaitem = requests.get(inurl).content
        b = BeautifulSoup(manhuaitem,features="html.parser")
        driver = webdriver.Chrome("C:\\Users\\bee\\Downloads\\chromedriver_win32\\chromedriver.exe",chrome_options=chrome_options)
        img(b,driver,iid,db)
            



def web(i): 
    url = "http://ac.qq.com/Comic/all/search/time/vip/1/page/"+str(i)
    page = requests.get(url)
    soup = BeautifulSoup(page.text,features="html.parser")
    ul = soup.find_all('ul')[2]
    li = ul.find_all('li')
    manhua(li)
        

if __name__ == '__main__':
    for i  in range(16,21):
        threading.Thread(target=web,args=(i,)).start()
        # for i  in range(6,11):
        #     threading.Thread(target=web,args=(i,)).start()
        #     time.sleep(0.1)
        # for i  in range(11,16):
        #     threading.Thread(target=web,args=(i,)).start()
        #     time.sleep(0.1)
        # for i  in range(16,21):
        #     threading.Thread(target=web,args=(i,)).start()
        #     time.sleep(0.1)






                    
                    



