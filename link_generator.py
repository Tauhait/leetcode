# generate a markdown file with link to each problem
import os
from os import listdir
from os import walk

link = 'https://github.com/acgtun/leetcode/tree/master/'

if __name__ == '__main__':
    langs = {'cpp':'cpp', 'java':'java', 'python':'py'}
    path = 'algorithms'

    solutions = {}
    problems = set()
    for lang in langs.keys():
        solutions[lang] = {}
        dir = os.path.join(path, lang)
        for dirpath, dirnames, filenames in walk(dir):
            for file in filenames:
                problem = file.replace('.' + langs[lang], ' ')
                solutions[lang][problem] = os.path.join(link, dir, file).replace(' ', '\%20')
                print(lang)
                print(problem)
                print(os.path.join(link, lang, file).replace(' ', '\%20'))
                problems.add(file.replace('.' + langs[lang], ' '))

    problems = list(problems)
    problems.sort()
    md_file = 'Readme.md'
    f = open(md_file, 'w')
    f.write('### LeetCode Solutions https://leetcode.com/problemset/algorithms/\n\n')
    f.write('|Problem | C/C++ | Java | Python3 |\n')
    f.write('|:----------|:-------------:|:------:|:------:|\n')
    for problem in problems:
        cpp_link = ''
        cpp_show = ''
        java_link = ''
        java_show = ''
        python_link = ''
        python_show = ''
        #problem_link = 'https://leetcode.com/problems/{}'.format(problem.replace(' ', '-'))
        if(problem in solutions['cpp'].keys()):
            cpp_show = 'cpp'
            cpp_link = solutions['cpp'][problem]
        if (problem in solutions['java'].keys()):
            java_show = 'java'
            java_link = solutions['java'][problem]
        if (problem in solutions['python'].keys()):
            python_show = 'python'
            python_link = solutions['python'][problem]
        f.write('|{} | [{}]({}) | [{}]({}) | [{}]({})|\n'.format(problem,
          cpp_show, cpp_link ,java_show, java_link, python_show, python_link))
    f.close()