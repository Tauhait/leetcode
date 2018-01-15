# generate a markdown file with links for all problems
import os
from os import listdir
from os import walk

link = 'https://github.com/acgtun/leetcode/blob/master/'

if __name__ == '__main__':
    langs = {'cpp': 'cpp', 'java': 'java', 'python': 'py'}
    path = 'algorithms'

    solutions = {}
    problems = set()
    for lang in langs.keys():
        solutions[lang] = {}
        dir = os.path.join(path, lang)
        for dirpath, dirnames, filenames in walk(dir):
            for file in filenames:
                if file == '.DS_Store':
                    continue
                problem = file.replace('.' + langs[lang], ' ')
                solutions[lang][problem] = os.path.join(link, dir, file).replace(' ', '%20')
                print(lang)
                print(problem)
                print(os.path.join(link, lang, file).replace(' ', '%20'))
                problems.add(file.replace('.' + langs[lang], ' '))

    problems = list(problems)
    problems.sort()
    md_file = 'Readme.md'
    f = open(md_file, 'w')
    f.write('### LeetCode Solutions [https://leetcode.com/problemset/algorithms/](https://leetcode.com/problemset/algorithms/)\n\n')
    f.write('[![Codacy Badge](https://api.codacy.com/project/badge/Grade/4b1151a2ceb949eaa46c000dc040bfd8)](https://www.codacy.com/app/chenhaifeng88888/leetcode?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=acgtun/leetcode&amp;utm_campaign=Badge_Grade)\n\n');
    f.write('|Problem | C/C++ | Java | Python3 |\n')
    f.write('|:----------|:-------------:|:------:|:------:|\n')
    for problem in problems:
        cpp_link = ''
        cpp_show = ''
        java_link = ''
        java_show = ''
        python_link = ''
        python_show = ''
        # problem_link = 'https://leetcode.com/problems/{}'.format(problem.replace(' ', '-'))
        if (problem in solutions['cpp'].keys()):
            cpp_show = 'cpp'
            cpp_link = solutions['cpp'][problem]
        if (problem in solutions['java'].keys()):
            java_show = 'java'
            java_link = solutions['java'][problem]
        if (problem in solutions['python'].keys()):
            python_show = 'python'
            python_link = solutions['python'][problem]
        f.write('|{} | [{}]({}) | [{}]({}) | [{}]({})|\n'.format(
            problem, cpp_show, cpp_link, java_show, java_link, python_show, python_link))
    f.close()
