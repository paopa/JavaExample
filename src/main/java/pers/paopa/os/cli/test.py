#! /usr/bin/env python
'''
gremlin.py
D. Thiebaut

This python program illustrates how to write a program
that will work equally well with information taken from
a file specified on the command line, or information
fed through stdin.

Typical use:

   chmod +x gremlin.py
   ./gremlin.py  someFileName.txt

   cat someFileName.txt | ./gremlin.py

'''

from __future__ import print_function
import sys
import time

def main():
    # open the first argument on command line, or stdin if none is specified
    with open(sys.argv[1], 'r') if len(sys.argv) > 1 else sys.stdin as f:
        # read the whole contents and put it in memory
        lines = f.readlines()
        f.close()


    # filter each line and replace 'g' characters by "gremlin",
    # upper or lowercase.
    for line in lines:
        time.sleep(1)
        print( line.strip()
               .replace('g', 'gremlin' )
               .replace( 'G', 'Gremlin' ))

main()