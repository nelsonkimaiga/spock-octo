# from os import listdir, system, sep
# from os.path import isfile, join
# import json
# import psycopg2
#
# # from jobonicJobs.models import Job
#
# print("Starting the hunt...")
#
# source_folder = "." + sep + "jobs" + sep
# all_jobs = []
#
# for f in listdir(source_folder):
#     if isfile(join(source_folder, f)):
#         with open(source_folder + f, "r") as jobs_file:
#             data = json.load(jobs_file)['data']
#
#             all_data = []
#             for d in data:
#                 d['model'] = 'jobonicJobs.job'
#                 d['title'] = d['title'][0]
#                 d['company_name'] = d['company_name'][0]
#                 all_data.append(d)
#
#             all_jobs += all_data
#
# try:
#     connect_str = "dbname='jobonics' user='jobonics' host='localhost' password='jobonics'"
#     for x in all_data:
#         conn = psycopg2.connect(connect_str)
#         cursor = conn.cursor()
#         query = "INSERT INTO jobonicJobs_job (title, url, location, job_type, salary, posted, company_logo, company_link, company_name, job_function, description, open) VALUES ('"+ x['title'] +"', '"+ x['url'] +"', )"
