from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
from selenium.common.exceptions import NoSuchElementException

import time

#browser = webdriver.Firefox()

############################KÜLALINE#################################
def initsieeriBrowser():
    print("Initsieerin browser Firefox")
    global browser
    browser = webdriver.Firefox()
    

def kuvaVeebileht():
    site = "http://p2kapikud.herokuapp.com"
    print("Kuvan lehekülg: "+site)
    browser.get(site)

def elementById(Id):
    print("Element by id: "+Id)
    return browser.find_element_by_id(Id)

def elementByClass(Class):
    print("Element by class: "+Class)
    return browser.find_element_by_class_name(Class)

def elementByTag(Tag):
    print("Element by tag: "+Tag)
    return browser.find_element_by_tag_name(Tag)

def elementByName(Name):
    print("Element by name: "+Name)
    return browser.find_element_by_name(Name)


def klickElement(element):
    print("Klikkin elemendil: "+element.text)
    #actionite läbiviija browseri külge
    actions = ActionChains(browser)
    #liigub nupu juurde
    actions.move_to_element(element)
    #vajutab
    actions.click_and_hold()
    #viib läbi eelnevalt kirjeldatud liigutused
    actions.release()
    actions.perform()


def karuselliVasakuleVajutus():
    print("Vajutan Karuselli Vasakule")
    #vasakule nuppu positsioon id kaudu
    vasak = elementByClass("karusell_button_left")
    klickElement(vasak)

def karuselliParemaleVajutus():
    print("Vajutan Karuselli Paremale")
    #paremale nuppu positsioon id kaudu
    parem = elementByClass("karusell_button_right")
    klickElement(parem)
    
def avaKaruselliUudis():
    print("Karuselli uudise avamine")
    uudis = elementByClass("active")
    uudise_link = uudis.find_element_by_tag_name("a")
    klickElement(uudise_link)

def lisaKommentaar(KasutajaNimi,Tekst):
    print("Kommentaari lisamine")
    try:
        nime_piirkond = elementByName("Nimi")
        nime_piirkond.send_keys(KasutajaNimi)
    except NoSuchElementException:
        print("No name field")
    sisu_piirkond = elementByName("content")
    sisu_piirkond.send_keys(Tekst)
    saada_nuppud = browser.find_elements_by_class_name("submit-button")
    saada_nupp = saada_nuppud[0]
    klickElement(saada_nupp)

def lisaKommentaarMitte(KasutajaNimi,Tekst):
    print("Kommentaari lisamine")
    try:
        nime_piirkond = elementByName("Nimi")
        nime_piirkond.send_keys(KasutajaNimi)
    except NoSuchElementException:
        print("No name field")
    sisu_piirkond = elementByName("content")
    sisu_piirkond.send_keys(Tekst)
    saada_nuppud = browser.find_elements_by_class_name("submit-button")
    print("Kasutaja mõtles ümber")
    time.sleep(3)
    saada_nupp = saada_nuppud[1]
    klickElement(saada_nupp)

def kustutaKommentaar():
    print("kustutan Meme kommentaari!")
    kommentaar = elementById("uudise-kommentaar-list").find_elements_by_tag_name("blockquote")[0]
    kustuta = kommentaar.find_element_by_tag_name("button")
    klickElement(kustuta)
    
def usecaseId1():
    print("Usecase1 - Saidi esilehe kuvamine")
    initsieeriBrowser()
    kuvaVeebileht()

def usecaseId2():
    print("Usecase2 - Paremale vasakule operatsioonid karuselliga")
    initsieeriBrowser()
    kuvaVeebileht()
    time.sleep(2)
    karuselliParemaleVajutus()
    time.sleep(2)
    karuselliParemaleVajutus()
    time.sleep(2)
    karuselliVasakuleVajutus()

def usecaseId3():
    print("Usecase3 - Uudise avamine karusellis")
    initsieeriBrowser()
    kuvaVeebileht()
    time.sleep(2)
    karuselliParemaleVajutus()
    time.sleep(2)
    avaKaruselliUudis()

def usecaseId4():
    print("Usecase4 - Kommentaari lisamine uudisele")
    initsieeriBrowser()
    kuvaVeebileht()
    time.sleep(2)
    avaKaruselliUudis()
    time.sleep(2)
    #kommentaari osa
    lisaKommentaar("Automated_test_user","Automated_test_user_text lol")
    
def usecaseId5():
    print("Usecase5 - Kommentaari lisamine ja loobumine lisamisest")
    initsieeriBrowser()
    kuvaVeebileht()
    time.sleep(2)
    avaKaruselliUudis()
    time.sleep(2)
    lisaKommentaarMitte("Automated_test_user","Automated_test_user_text lol")

def naviBarKlick(nr):
    navigatsioon = elementById("top-navi")
    valikud = navigatsioon.find_elements_by_tag_name("a")
    link = valikud[nr]
    klickElement(link)

def usecaseId6():
    print("Usecase6 - Kõigi uudiste kuvamine")
    initsieeriBrowser()
    kuvaVeebileht()
    time.sleep(2)

    naviBarKlick(1)

def usecaseId7():
    print("Usecase7 - Sorteerimine")
    initsieeriBrowser()
    kuvaVeebileht()
    time.sleep(2)

    naviBarKlick(1)

    head = elementByTag("thead")
    pead = head.find_elements_by_tag_name("th")
    kp = pead[0]
    ka = pead[1]
    pk = pead[2]
    ko = pead[3]
    
    print("Sordi kuupäeva järgi!")
    klickElement(kp)
    time.sleep(5)
    klickElement(kp)
    time.sleep(5)
    print("Sordi kellaaja järgi!")
    klickElement(ka)
    time.sleep(5)
    klickElement(ka)
    time.sleep(5)
    print("Sordi pealkirja järgi!")
    klickElement(pk)
    time.sleep(5)
    klickElement(pk)
    time.sleep(5)
    print("Sordi kommentaaride järgi!")
    klickElement(ko)
    time.sleep(5)
    klickElement(ko)


def usecaseId8():
    print("Usecase8 - Uudise otsimine")
    initsieeriBrowser()
    kuvaVeebileht()

    otsing = elementByName("otsing")
    otsing.send_keys("uudis"+Keys.RETURN)
    time.sleep(5)
    otsing = elementByName("otsing")
    otsing.send_keys("uudiste"+Keys.RETURN)


    
############################AJAKIRJANIK#################################
def registreeruVorm(enimi,pnimi,knimi,pwd):
    registreeru = elementById("registreeru-vorm").find_elements_by_tag_name("input")
    print("Sent name: "+enimi)
    registreeru[0].send_keys(enimi)
    print("Sent surename: "+pnimi)
    registreeru[1].send_keys(pnimi)
    print("Sent username: "+knimi)
    registreeru[2].send_keys(knimi)
    print("Sent pass: "+pwd)
    registreeru[3].send_keys(pwd)
    print("Sent pass: "+pwd)
    registreeru[4].send_keys(pwd)
   
    
def usecaseId9():
    print("Usecase9 - Registreerumine")
    initsieeriBrowser()
    kuvaVeebileht()
    time.sleep(2)

    meldi_nupp = elementById("login")
    klickElement(meldi_nupp)

    registreeru_nupp = elementById("navi-buttons-registreeri")
    klickElement(registreeru_nupp)

    registreeruVorm("testName","testSurename","testUser","Test")

    vorm = elementById("register")
    rega_nupp = vorm.find_elements_by_tag_name("button")[0]
    
    klickElement(rega_nupp)
    
    

def tavalineSisselogimine(Kasutaja,Parool):
    kasutaja = elementByName("k-nimi")
    kasutaja.send_keys(Kasutaja)

    parool = elementByName("pwd")
    parool.send_keys(Parool)

def usecaseId10():
    print("Usecase10 - Sisselogimine")
    initsieeriBrowser()
    kuvaVeebileht()
    time.sleep(2)

    meldi_nupp = elementById("login")
    klickElement(meldi_nupp)

    tavalineSisselogimine("h","")
    time.sleep(2)
    
    vorm = elementById("meldi_integr")
    logi_nupp = vorm.find_elements_by_tag_name("button")[0]
    
    klickElement(logi_nupp)
    

def usecaseId11():
    print("Usecase11 - Sisselogimise katkestamine")
    initsieeriBrowser()
    kuvaVeebileht()
    time.sleep(2)

    meldi_nupp = elementById("login")
    klickElement(meldi_nupp)

    tavalineSisselogimine("h","")
    time.sleep(2)
    
    vorm = elementById("meldi_integr")
    logi_nupp = vorm.find_elements_by_tag_name("button")[1]
    
    klickElement(logi_nupp)

def lisaUudis(name,url,sisu,tags):
    pealkiri = elementByName("pealkiri")
    pilt = elementByName("pilt")
    tekst = elementByName("tekst")
    tagid = elementByClass("uudise-tagid")

    pealkiri.send_keys(name)
    pilt.send_keys(url)
    tekst.send_keys(sisu)
    tagid.send_keys(tags)
    

def usecaseId12():
    print("Usecase12 - Uudise lisamine")
    initsieeriBrowser()
    kuvaVeebileht()
    time.sleep(2)

    meldi_nupp = elementById("login")
    klickElement(meldi_nupp)

    tavalineSisselogimine("h","")
    time.sleep(2)
    
    vorm = elementById("meldi_integr")
    logi_nupp = vorm.find_elements_by_tag_name("button")[0]
    
    klickElement(logi_nupp)

    naviBarKlick(2)

    lisaUudis("Automaattesti Uudis","http://5to9branding.files.wordpress.com/2011/06/best-job.jpg","Automaattesti uudis, lahe right","Uudis, Automaattest")

    nupu_div = elementByClass("tegevus-nupud")
    nupp = nupu_div.find_elements_by_tag_name("button")[0]
    klickElement(nupp)

def usecaseId13():
    print("Usecase13 - Uudise lisamine ning lisamisest loobumine")
    initsieeriBrowser()
    kuvaVeebileht()
    time.sleep(2)

    meldi_nupp = elementById("login")
    klickElement(meldi_nupp)

    tavalineSisselogimine("h","")
    time.sleep(2)
    
    vorm = elementById("meldi_integr")
    logi_nupp = vorm.find_elements_by_tag_name("button")[0]
    
    klickElement(logi_nupp)

    naviBarKlick(2)

    lisaUudis("Automaattesti Uudis","http://5to9branding.files.wordpress.com/2011/06/best-job.jpg","Automaattesti uudis, lahe right","Uudis, Automaattest")
    time.sleep(2)
    print("Kasutaja mõtles ümber ja ei taha uudist lisada, tühjendab väljad")
    nupu_div = elementByClass("tegevus-nupud")
    nupp = nupu_div.find_elements_by_tag_name("button")[1]
    klickElement(nupp)

############################ADMIN#################################
def usecaseId14():
    print("Usecase14 - Uudise kustutamine")
    initsieeriBrowser()
    kuvaVeebileht()
    time.sleep(2)

    meldi_nupp = elementById("login")
    klickElement(meldi_nupp)

    tavalineSisselogimine("meme","memee")
    time.sleep(2)
    
    vorm = elementById("meldi_integr")
    logi_nupp = vorm.find_elements_by_tag_name("button")[0]
    
    klickElement(logi_nupp)

    naviBarKlick(1)

    tabel = elementByTag("table")

    leitud = False
    for rida in tabel.find_elements_by_tag_name("tr"):
        for veerg in rida.find_elements_by_tag_name("td"):
            if(veerg.text=="Automaattesti Uudis"):
                leitud = True
                break
        if (leitud):
            kustuta = rida.find_element_by_tag_name("button")
            klickElement(kustuta)
            break

    if(not leitud):
        kustuta = tabel.find_element_by_tag_name("button")
        klickElement(kustuta)

    print("Uudis kustutatud")

def usecaseId15():
    print("Usecase15 - Kommentaari kustutamine")
    initsieeriBrowser()
    kuvaVeebileht()
    time.sleep(2)

    meldi_nupp = elementById("login")
    klickElement(meldi_nupp)

    tavalineSisselogimine("meme","memee")
    time.sleep(2)
    
    vorm = elementById("meldi_integr")
    logi_nupp = vorm.find_elements_by_tag_name("button")[0]
    
    klickElement(logi_nupp)

    avaKaruselliUudis()
    lisaKommentaar("","Kommentaar mis läheb kustu")
    print("kommentaar lisatud!")
    time.sleep(5)
    kustutaKommentaar()
    

def main():
    usecaseId1()
    print()
    print()
    usecaseId2()
    print()
    print()
    usecaseId3()
    print()
    print()
    usecaseId4()
    print()
    print()
    usecaseId5()
    print()
    print()
    usecaseId6()
    print()
    print()
    usecaseId7()
    print()
    print()
    usecaseId8()
    print()
    print()
    usecaseId9()
    print()
    print()
    usecaseId10()
    print()
    print()
    usecaseId11()
    print()
    print()
    usecaseId12()
    print()
    print()
    usecaseId13()
    print()
    print()
    usecaseId14()
    print()
    print()
    usecaseId15()

##Testide läbiviimiseks kommenteerida järgmine rida sisse
#main()





