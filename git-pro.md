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
6. Use -a option to the **git commit** command makes Git skipping the staging area
7. To remove a file from Git, you have to remove it from your tracking files and then commit. **git rm** command also removes the file from your working direcotry. If you modified the file and added it to the index already, you must force the removal with the -f option.
Use **git rm --cached** to keep the file in working tree but remove it from staging area.
```git rm log/\*.log```. Note the backslash (\) in front of the *. This is necessary because Git does its own filename expansion in addition to your shell's filename expansion.
8. ```git mv file_from file_to``` rename a file in Git.
9. ```git commit --amend```, this command takes your staging area and uses it for the commit. If you've made no changes since your last commit, then your snapshot will look exactly the same, and all you'll change is your commit message.
```
git commit -m 'initial commit'
git add forgotten_file
git commit --amend
```
You end up with a single commit, -- the second replaces the result of the first.
10. Use ```git reset HEAD <file>``` to unstaged.
11. Unmodifying a modified file:```git checkout -- <file>``` 
12. Showing your remote: ```git remote -v```.  **clone** command implicitly adds the *origin* remote for you.
To add a new remote Git repository as a shortname, you can reference easily, use ```git remote add <shortname> <url>```.
13. Fetching and Pulling from your remotes: ```git fetch <remote_name>```. After this, you should have references to all the branches from that remote.
It's important to note that the **git fetch** command only downloads the data to your local repository - it doesn't automatically merge it with any of your work or modify what you're currently working on. You have to merge it manually into your work. If your current branch is set up to track a remote branch, you can use the ```git pull``` command to automatically fetch and then merge that remote branch into your current branch.
By default, the ```git clone``` command automatically sets up your local master branch to track the remote branch on the server you cloned from.
14. Pushing to your remotes:```git push <remote-name> <branch-name>```, like ```git push origin master```. If you and someone else clone at the same time and they push upstream, your push will rightly be rejected. You'll have to fetch first and incorporate it into yours before you'll be allowed to push.
15. Inspecting a remote:```git remote show <remote-name>```. 
Rename a remote:```git remote rename <old-name> <new-name>```
Removing a reomte:```git remote rm <shortname>```
16. Listing your tags:```git tag```.  You can search for tags with a particular pattern, ```git tag -l "v1.8.5*"```.
17. Git uses two main types of tags: lightweight and annotated.
 * A lightweight tag is very much like a branch that doesn't change - it's just a pointer to a specific commit. ```git tag v1.4```
 * Annotated tags are stored as full objects in the Git database. ```git tag -a v1.4 -m "my version 1.4```
It's generally recommended that you create annotated tags so you can have all this information; but if you want a temporary tag, lightweigh tags are available too.
 * Show the tag data:```git show v1.4```
18. Tagging later. You can add a tag after the commit, by specifying the commit checksum (or part of it) at the end of command:
```gti tag -a v1.2 9fceb02```
19. By default, the **git push** command doesn't transfer tags to remote servers. You will have to explicitly push tags to a shared server after you have created them: ```git push origin <tagname>```, or ```git push origin --tags```.
20. You can't really check out a tag in Git, since they can't be moved around. You can create a new branch at a specific tag with the command: ```git checkout -b [branchname] [tagname]```.
21. Git Aliases:
```
git config --global alias.co checkout
git config --global alias.br branch
git config --global alias.unstage 'reset HEAD --'
git config --global alias.last 'log -l HEAD'
```
If you want to run an external command, you start the command with a ! character.
```git config --global alias.visual '!gitk'```

## Chapter 3 Git Branching
1. Creating a new branch: git branch testing.
In Git, HEAD is pointer to the local branch you're currently on.
To show you where the branch pointers are pointing, use: ```git log --oneline --decorate```
2. Switching branches: ```git checkout testing```. If you switch to an older branch, your working directory will be reverted to look like it did the last time you committed on that branch. If Git cannot do it clearly, it will not let you switch at all. It's best to have clean working state when you switch branches.
3. ```git log --oneline --decorate --graph --all```, it will print out the history of your commits, showing where your branch pointers are and how your history has diverged. 
4. To create a branch and switch to it at the same time, use:```git checkout -b <name>```.  
5. To merge *hotfix* back into your *master* branch:
```
git checkout master
git merge hotfix
```
Instead of just moving the branch pointer forward, Git creates a new snapshot that results from a three-way merge and automatically creates a new commit that points to it. This is refered to as a **merge commit**, and is special in that it has more than one parent.
6. To delete a branch: ```git branch -d hotfix```
7. If you want to use a graphical tool to resolve the conflict, use:```git mergetool```. Run ```git status``` to verify that all conflicts have been resolved. And run ```git commit``` to finalize the merge commit.
8. To see the last commit on each branch, run:```git branch -v```. The useful **--merged** and **--no-merged** options can filter this list to branches that you have or have not yet merged into the branch you're currently on.
```git branch --merged```, branches on this list without the \* in front of them are generally fine to delete. 
An not-merged branch contains work that isn't merged in yet, trying to delete it with **git branch -d** will fail, if not forced with -D.
9. Remote references are references (pointers) in your remote repositories, including branches, tags, and so on. You can get a full list of remote references explicitly with ```git ls-remote [remote]```, or ```git remote show [remote]```.
10. Remote-tracking branches are references to the state of remote branches. They're local references that you can't move; they're moved automatically for you whenever you do any network communication. Remote-tracking branches act as bookmarks to remind you where the branches in your remote repositories were that last time you connected to them. They take the form (remote)/(branch), like *origin/master*.
11. To push a branch you want to share, run:```git push <remote> <branch>```. If you have a branch named **serverfix**, run:```git push origin serverfix```.
Git automatically expands the **serverfix** branchname out to *refs/heads/serverfix:refs/heads/serverfix*, which means, "take my serverfix local branch and push it to update the remote's serverfix branch". You can also do **git push origin serverfix:serverfix**, which does the same thing, it says, "take my serverfix and make it the remote's serverfix". To use a different name on the remote, ```git push origin serverfix:awesomefix```.
12. It's important to note that when you do a fetch that brings down new remote-tracking branches, you don't automatically have local, editable copies of them.You only have a pointer that you can't modify. To merge a remote-tracking branch, run ```git merge origin/serverfix```. If you want your own **serverfix** branch that you can work on, run: ```git checkout -b serverfix origin/serverfix```.
13. Checking out a local branch from a remote-tracking branch automatically creates what is called a "tracking branch" (and the branch it tracks is called an "upstream branch"). Tracking branches are local branches that have a direct relationship to a remote branch. If you're on a tracking branch and type **git pull**, Git automatically knows which server to fetch from and branch to merge into.
Run:```git checkout -b [branch] [remote]/branch]```. Git provides the **--track** shorthand for this: ```git checkout --track origin/serverfix```.
In fact, this is so common that there's even a shortcut for that shortcut. If the branch name you're trying to checkout (a) doesn't exist and (b) exactly matches a name on only one remote, Git will create a tracking branch for you. Run:```git checkout serverfix```.
If you already have a local branch and want to set it to a remote branch you just pulled down, or want to change the upstream branch you're tracking, you can use the **-u** or **--set-upstream-to** option: ```git branch -u origin/serverfix```.
14. When you have a tracking branch set up, you can reference its upstream branch with the **@{upstream}** or **@{u}** shorthand, like ```git merge @{u}``` instead of ```git merge origin/master``` if you wish.
15. To see what tracking branches you have set up, run:```git branch -vv```. This will list out your local branches with more information including what each branch is tracking and if your local branch is ahead, behind or both. This command does not reach out to the servers, it's telling you about what it has cached from these servers locally. If you want totally up to date ahead and behind numbers, you'll need to fetch from all your remotes right before running this. run:```git fetch --all; git branch -vv```.
16. Generally it's better to simply use the **fetch** and **merge** commands explicitly as the magic of **git pull** can often be confusing.
17. If you want to delete your **serverfix** branch from the server, run ```git push origin --delete serverfix```. Basically all this does is remove the pointer from the server. The Git server will generally keep the data there for a while until a garbage collection runs, so if it was accidentally deleted, it's often easy to recover.
18. With the **rebase** command, you can take all the changes that were committed on one branch and reply them on another one.
19. **Do not rebase commits that exist outside your repository.**

## Chapter 4 Git on the server
1. 




## Chapter 10
1. When you run **git init** in a new or existing directory, Git creates the .git directory, which is where almost everything that Git stores and manipulates is located. If you want to back up or clone your repository, copying this single directory elsewhere gives you nearly everything you need.
 * The **object** stores all the content for your database
 * The **refs** stores pointers into commit objects in that data(branches)
 * The HEAD file points to the branch you currently have checked out
 * The **index** file is where Git stores your staging area information.

2. 
