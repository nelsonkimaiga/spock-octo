import json
import os

import requests
from bs4 import BeautifulSoup

brighter_monday = "https://www.brightermonday.co.ke/jobs/?page="


def scrap_page(page_number):
    print("Scrapping Page : " + str(page_number) + " of 55")

    bm_jobs = requests.get(
        url=brighter_monday + str(page_number),
    )

    bm_jobs_content = bm_jobs.content
    soup = BeautifulSoup(bm_jobs_content, "html.parser")
    jobs = soup.find_all('article', attrs={'class': 'search-result'})
    return jobs[:-1]


def get_job_details(jobs):
    return [
        {
            "title": job.find('a', {'class': 'search-result__job-title'}).find('h3').text,
            "url": job.find('a', {'class': 'search-result__job-title'})['href'],
            "location": job.find('div', {'class': 'search-result__location'}).find('a').text,
            "job_type": job.find('div', {'class': 'search-result__job-type'}).text.replace("\n", ""),
            "salary": job.find('div', {'class': 'search-result__job-salary'}).text.replace("\n", "").replace("KSh",
                                                                                                             "").strip(),
            'posted': job.find('div', {'class': 'search-result__job-meta'}).text.replace("\n", "").strip(),
            'company': {
                'logo': job.find('img', {'class': 'employer-logo__image'})['src'],
                'link': job.find('div', {'class': 'search-result__job-meta'}).find('a')['href'],
                'name': job.find('div', {'class': 'search-result__job-meta'}).find('a').text.replace("\n", "").strip(),
            },
            "job_function": job.find('div', {'class': 'search-result__job-category'}).find('a').text,
            "description": job.find('div', {'class': 'search-result__content'}).find('p').text.strip()
        } for job in jobs]


if __name__ == "__main__":
    alljobs = []
    for i in range(1, 56):
        jobs = scrap_page(i)
        j = get_job_details(jobs)
        for x in j:
            alljobs.append(x)

    print("Scrapped " + str(len(alljobs)) + " jobs")

    with open('jobs' + os.sep + 'brighter_monday.json', 'w') as bm_writer:
        json.dump({'data': alljobs}, bm_writer)

    print("Written changes to file")
