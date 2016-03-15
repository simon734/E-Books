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



## Chapter 10
1. When you run **git init** in a new or existing directory, Git creates the .git directory, which is where almost everything that Git stores and manipulates is located. If you want to back up or clone your repository, copying this single directory elsewhere gives you nearly everything you need.
 * The **object** stores all the content for your database
 * The **refs** stores pointers into commit objects in that data(branches)
 * The HEAD file points to the branch you currently have checked out
 * The **index** file is where Git stores your staging area information.

2. 
