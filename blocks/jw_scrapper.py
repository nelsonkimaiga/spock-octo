import json
import os
import logging

import requests
from bs4 import BeautifulSoup


logging.basicConfig(filename='log.log', level=logging.DEBUG)
job_web = "https://jobwebkenya.com/jobs/page/"


def scrap_page(page_number):
    logging.debug("Scrapping page : " + str(page_number) + " " +  job_web + str(page_number))
    print("Scrapping page : " + str(page_number) + " " +  job_web + str(page_number))
    jw_jobs = requests.get(
        url=job_web + str(page_number)
    )

    content = jw_jobs.content
    soup = BeautifulSoup(content, "html.parser")
    return soup.find_all('li', attrs={'class': 'job'})


def get_job_details(j):
    return [
        {
            "title": job.find('div', attrs={'id': 'titlo'}).find('a').text.split(' : '),
            "url": job.find('div', attrs={'id': 'titlo'}).find('a')['href'],
            "location": job.find('div', attrs={'id': 'location'}).find('strong').text,
            "job_type": job.find('div', attrs={'id': 'type-tag'}).find('span').text,
            "salary": "N\A",
            'posted': job.find('div', attrs={'id': 'date'}).find('span').text,
            'company_logo': "https://jobwebkenya.com/wp-content/uploads/2017/04/jobwebken.png",
            "company_name": job.find('div', attrs={'id': 'titlo'}).find('a').text.split(' : '),
            'company_link': "https://jobwebkenya.com",
            "job_function": job.find('div', attrs={'id': 'type-tag'}).find('span').text,
            "description": job.find('div', attrs={'id' : 'exc'}).text.replace("\n", "")
        } for job in j
    ]


if __name__ == "__main__":
    alljobs = []
    for i in range(830, 2344):
        jobs = scrap_page(i)
        try:
            j = get_job_details(jobs)
            for x in j:
                alljobs.append(x)
            with open('jobs' + os.sep + 'job_web_kenya_8.json', 'w') as bm_writer:
                json.dump({'data': alljobs}, bm_writer)
        except:
            logging.warning("Skipping " + str (i))
            print("Skipping " + str (i))

    logging.debug("Scrapped " + str(len(alljobs)) + " jobs")
    print("Scrapped " + str(len(alljobs)) + " jobs")

