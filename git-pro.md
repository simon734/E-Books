## Chapter 1
1. The major difference between Git and other VCS is the way Git thinks about its data.
2. Nearly every operation is local.
3. Git has three main states that your files can reside in:
 * committed, means that the data is safely stored in your local database.
 * modified, means that you have change the file but have not committed it to your database yet.
 * staged, means that you have marked a modified file in its current version to go into your next commit snapshot.
Threee main sections of a Git project: the Git directory(repository), the working directory, and the staging area.
The staging area is a file, generally contained in your Git directory. It's sometimes refered to as the "index".
4. The basic Git workflow goes like this:
 * You modify files in your working directory
 * You stage the file, adding snapshots of them to your staging area.
 * You do a commit, which takes the files as they are in the staging area and stores that snapshot permanently to your Git directory      
5. **git config** can be used to change configuration in three different places:
 * --system
 * --global: Specific to your user
 * Specific to a single repository
Each level overrides values in the previous level. The first thing you should do when you install Git is to set your name and email address. This is important because every Git commit uses this information. 
```
git config --global user.name "simon wu"
git config --global user.email "simon734@gmail.com"
git config --list
``` 

## Chapter 2
1. Each file in your working directory can be in one of two states: tracked or untracked. Tracked files are files that were in the last snapshot; they can be unmodified, modified, or staged. Untracked files are in your working directory that were not in your last snapshot and are not in your staging area.
2. **git add** is a multipurpose command. You use it to begin tracking new files, to stage files, and to do other things like marking merge-conflicted files as resolved. It may be helpful to think of it more as "add this content to the next commit".
3. Use **git status -s ** or **git status --short** to get a far more simplified output from the command.
```
$ git status -s
 M README
MM Rakefile
A  lib/git.rb
M  lib/simplegit.rb
?? LICENSE.txt
```
New files that aren't tracked have a ?? next to them, new files that have been added to the staging area have an A, modified files have an M.
There are two columns to the output - the left hand column indicates that the file is staged and the right hand column indicates that it's modified. So the README file is in the working directory but not yet staged, while the lib/simplegit.rb file is modified and staged. The Rakefile was modified, staged and then modified again, so there are changes to it that are both staged and unstaged.
4. The rules for the patterns you can put in the *.gitignore* file are as follows:
 * Blank lines or lines starting with # are ignored
 * Standard glob patterns work
 * You can start patterns with a forward slash (/) to avoid recursivity
 * You can end patterns with a forward slash (/) to specify a directory
 * You can negate a pattern by starting it with an exclamation point(!)
Glob patterns are like simplified regular expressions that shells use. And you can also use two asterisks to match nested directories; *a/**/z* would match a/z, a/b/z, a/b/c/z, and so on.
```
# only ignore the TODO file in the current directory, not subdir /TODO
/TODO
```
Refer to: https://github.com/github/gitignore if you want a starting point for your project.
5. **git diff** compares what is in your working directory with what is in your staging area, i.e., the changes you've made that you haven't yet staged.
**git diff --staged** (or --cached) compares your staged changes to your last commit. 
Run **git difftool --tool-help** to see what diff tools are available on your system.


## Chapter 10
1. When you run **git init** in a new or existing directory, Git creates the .git directory, which is where almost everything that Git stores and manipulates is located. If you want to back up or clone your repository, copying this single directory elsewhere gives you nearly everything you need.
 * The **object** stores all the content for your database
 * The **refs** stores pointers into commit objects in that data(branches)
 * The HEAD file points to the branch you currently have checked out
 * The **index** file is where Git stores your staging area information.

2. 
