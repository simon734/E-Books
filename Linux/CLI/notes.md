* A command can be one of four diffenent things:
    * An executable program.
    * A command built into the shell itself.
    * A shell function. These are miniature shell scripts incorporated int the environment.
    * An alias.

* Some useful commands:
    * type - indicate how a command name is interpreted
    * which - display which executable program will be executed
    * help - get help for shell builtins
    * man - display a command's manual page
    * apropos - display a list of appropriate commands
    * info - display a command's info entry
    * whatis - display a very brief description of a command
    * alias - create an alias for a command

* Man pages do not usually includes examples, and are inteded as a reference, not a tutorial.
* **man** uses **less** to display the manual pages.
* Man Page Organization: Section  --> Contents
    * 1 User commands
    * 2 Programming interfaces for kernel system calls
    * 3 Programming intefaces to the C library
    * 4 Special files such as device nodes and drivers
    * 5 File formats
    * 6 Games and amusements such as screen savers
    * 7 Miscellaneous
    * 8 System administration commands
* Without specifying a section number, we will always get the first instance of a match.
* The **man** command with the '-k' option performs the exact same fucntion as **apropos**.
* Try **whatis socket**.
* The GNU Project provides an alternative to man pages for their programs, called **info**.
* Many software packages installed on your system have documentation files residing in the **/usr/share/doc** directory. The gzip package includes a special version of **less** called **zless** that will display the contents of gzip-compressed text files.
* Put more than one command on a line by separating each command with a semicolon character.
* Naming an alias with an existing command name is often done to apply a commonly desired option to each invocation of a common command.
* The Bash Reference Manual is a reference guide to the bash shell. It’s still a reference work but contains examples and is easier to read than the bash man page. http://www.gnu.org/software/bash/manual/bashref.html
* The GNU Project provides extensive documentation for its programs, which form the core of the Linux command line experience. You can see a complete list here: http://www.gnu.org/manual/manual.html
* To truncate a file (or create a new, empty file), we can use a trick like: **> output.txt**
* Redirecting stardard output and standard error to one file:
    * (Traditional)command > output_file 2>&1
    * (Recent bash supports more streamlined method) command &> output_file
* Disposing of unwanted output: **2> /dev/null**
* Join files together: cat movie.mpeg.0* > movie.mpeg
    * Since wildcards always expand in sorted order, the arguments will be arranged in the correct order.
* Type **Ctrl-d** to tell **cat** that it has reached EOF on standard input.
* **cat > filename.txt**, we can create a new file.
* tee -- Read from stdin and output to stdout and files
* Tilde Expansion: echo ~simon
* Arithmetic expansion uses the form: **$((expression))**, for example, echo $((2+2)). Only support integers (whole numbers, no decimals).
    * Spances are not significant in arithmetic expressions and expressions may be nested. echo $(($((5\*\*2)) * 3))
    * Single parentheses may be used to group multiple subexpressions. Like: echo $(((5 \*\* 2) * 3))
* Brace Expansion and examples:
    * echo Front-{A,B,C}-Back
    * echo Number_{1..5}
    * echo {01..15}
    * echo {001..15}
    * echo {Z..A}
    * echo a{A{1,2}, B{3,4}}b
    * echo {2007..2009}-{01..12}
* Parameter Expansion: echo $USER; printenv | less
* Command substitution and examples:
    * echo $(ls)
    * ls -l $(which cp)
    * file $(ls -d /usr/bin/* | grep zip)
    * ls -l `which cp`
* If we place text inside double quotes, all the special characters used by the shell lose their special meaning and are treated as ordinary characters. The exceptions are "$", "\", and "`". For example, echo "$USER $((2+2)) $(cal)"
* Using single quotes to suppress all expansions.
* The **bash** man page has major sections on both expansion and quoting.
* Command Line Editing
    * Cursor Movement Commands:
        Ctrl-a Move cursor to the beginning of the line.
        Ctrl-e Move cursor to the end of the line.
        Ctrl-f Move cursor forward one character; same as the right arrow key.
        Ctrl-b Move cursor backward one character; same as the left arrow key.
        Alt-f Move cursor forward one word.
        Alt-b Move cursor backward one word.
        Ctrl-l Clear the screen and move the cursor to the top left corner. The clear command does the same thing.
    * Text Editing Commands:
        Ctrl-d Delete the character at the cursor location
        Ctrl-t Transpose (exchange) the character at the cursor location with the one preceding it.
        Alt-t Transpose the word at the cursor location with the one preceding it.
        Alt-l Convert the characters from the cursor location to the end of the word to lowercase.
        Alt-u Convert the characters from the cursor location to the end of the word to uppercase.
    * Cut And Paste Commands:
        Ctrl-k Kill text from the cursor location to the end of line.
        Ctrl-u Kill text from the cursor location to the beginning of the line.
        Alt-d Kill text from the cursor location to the end of the current word.
        Alt-Backspace Kill text from the cursor location to the beginning of the current word. If the cursor is at the beginning of a word, kill the previous word.
        Ctrl-y Yank text from the kill-ring and insert it at the cursor location.
* Completion will work on pathnames, variables (if the beginning of the word is a "$"), use names (if the word begins with "~"), commands (if the word is the first word on the line) and hostnames (if the beginning of the word is "@"). Hostname completion only works for hostnames listed in **/etc/hosts**.
* Completion Commands:
    Alt-? Display list of possible completions. On most systems you can also do this by pressing the tab key a second time, which is much easier.
    Alt-* Insert all possible completions. This is useful when you want to use more than one possible match.
* History Commands:
    Ctrl-p Move to the previous history entry. Same action as the up arrow.
    Ctrl-n Move to the next history entry. Same action as the down arrow.
    Alt-< Move to the beginning (top) of the history list.
    Alt-> Move to the end (bottom) of the history list, i.e., the current command line.
    Ctrl-r Reverse incremental search. Searches incrementally from the current command line up the history list.
    Alt-p Reverse search, non-incremental. With this key, type in the search string and press enter before the search is performed.
    Alt-n Forward search, non-incremental.
    Ctrl-o Execute the current item in the history list and advance to the next one. This is handy if you are trying to re-execute a sequence of commands in the history list.
* History Expansion Commands:
    !! Repeat the last command. It is probably easier to press up arrow and enter.
    !number Repeat history list item number.
    !string Repeat last history list item starting with string.
    !?string Repeat last history list item containing string.
* **script** command can be used to record an entire shell session and store it in a a file.
* /etc/passwd: user account definition, /etc/group: group definition, /etc/shadow: information about user's password.
* File Types:
    - File Type
    d A directory.
    l A symbolic link. Notice that with symbolic links, the remaining file attributes are always “rwxrwxrwx” and are dummy values. The real file attributes are those of the file the symbolic link points to.
    c A character special file. This file type refers to a device that handles data as a stream of bytes, such as a terminal or modem.
    b A block special file. This file type refers to a device that handles data in blocks, such as a hard drive or CD-ROM drive.
* Permission Attributes:
    r 
    Files: Allows a file to be opened and read.
    Directories: Allows a directory's contents to be listed if the execute attribute is also set.
    w
    Files: Allows a file to be written to or truncated, however this attribute does not allow files to be renamed or deleted. The ability to delete or rename files is determined by directory attributes.
    Directories: Allows files within a directory to be created, deleted, and renamed if the execute attribute is also set.
    x 
    Files: Allows a file to be treated as a program and executed. Program files written in scripting languages must also be set as readable to be executed.
    Directories: Allows a directory to be entered, e.g., cd directory.
* chmod Sysbolic Notation Examples:
    u+x Add execute permission for the owner.
    u-x Remove execute permission from the owner.
    +x Add execute permission for the owner, group, and world. Equivalent to a+x.
    o-rw Remove the read and write permission from anyone besides the owner and group owner.
    go=rw Set the group owner and anyone besides the owner to have read and write permission. If either the group owner or world previously had execute permissions, they are removed.
    u+x,go=rx Add execute permission for the owner and set the permissions for the group and others to read and execute. Multiple specifications may be separated by commas.
* setuid: When an ordinary user runs a program that is "setuid root", the program runs with the effective privileges of the superuser.
* setgid: Newly created files in the directory will be given ownership of the directory rather the group ownership of the file's creator.
* sticky bit: It prevents users from deleting or renaming files unless the user is either the owner of the directory, the owner of the file, or the superuser. This is often used to control access to a shared directory, such as /tmp.
* Assigning setuid to a program: chmod u+s program, such as: -rwsr-xr-x
* Assigning setgid to a directory: chmod g+s dir, such as: drwxrwsr-x
* Assigning the sticky bit to a directory: chmod +t dir, such as: drwxrwxrwt
* chown Argument Examples:
    bob Changes the ownership of the file from its current owner to user bob.
    bob:users Changes the ownership of the file from its current owner to user bob and changes the file group owner to group users.
    :admins Changes the group owner to the group admins. The file owner is unchanged.
    bob: Change the file owner from the current owner to user bob and changes the group owner to the login group of user bob.
* ps: Process States:
    R Running. This means that the process is running or ready to run.
    S Sleeping. The process is not running; rather, it is waiting for an event, such as a keystroke or network packet.
    D Uninterruptible Sleep. Process is waiting for I/O such as a disk drive.
    T Stopped. Process has been instructed to stop. 
    Z A defunct or “zombie” process. This is a child process that has terminated, but has not been cleaned up by its parent.
    < A high priority process. It's possible to grant more importance to a process, giving it more time on the CPU. This property of a process is called niceness. A process with high priority is said to be less nice because it's taking more of the CPU's time, which leaves less for everybody else.
    N A low priority process. A process with low priority (a “nice” process) will only get processor time after other processes with higher priority have been serviced.
* A popular set of option for ps is "aux" (without a leading dash).
* Sending signals to processes with kill:
    1 HUP Hangup. This is a vestige of the good old days when terminals were attached to remote computers with phone lines and modems. The
    signal is used to indicate to programs that the controlling terminal has “hung up.” The effect of this signal can be demonstrated by closing a terminal session. The foreground program running on the terminal will be sent the signal and will terminate.
    This signal is also used by many daemon programs to cause a reinitialization. This means that when a daemon is sent this signal, it will restart and re-read its configuration file. The Apache web server is an example of a daemon that uses the HUP signal in this way.
    2 INT Interrupt. Performs the same function as the Ctrl-c key sent from the terminal. It will usually terminate a program.
    9 KILL Kill. This signal is special. Whereas programs may choose to handle signals sent to them in different ways, including ignoring them all together, the KILL signal is never actually sent to
    the target program. Rather, the kernel immediately terminates the process. When a process is terminated in this manner, it is given no opportunity to “clean up” after itself or save its work. For this reason, the KILL signal should only be used as a last resort when other termination signals fail.
    15 TERM Terminate. This is the default signal sent by the kill command. If a program is still “alive” enough to receive signals, it will terminate.
    18 CONT Continue. This will restore a process after a STOP signal.
    19 STOP Stop. This signal causes a process to pause without terminating. Like the KILL signal, it is not sent to the target process, and thus it cannot be ignored.
    3 QUIT Quit.
    11 SEGV Segmentation Violation. This signal is sent if a program makes illegal use of memory, that is, it tried to write somewhere it was not allowed to.
    20 TSTP Terminal Stop. This is the signal sent by the terminal when the Ctrl-z key is pressed. Unlike the STOP signal, the TSTP signal is received by the program but the program may choose to ignore it.
    28 WINCH Window Change. This is the signal sent by the system when a window changes size. Some programs , like top and less will respond to this signal by redrawing themselves to fit the new window dimensions.
* Send signals to multiple processes with killall matching a specified program or username.
* You must have superuser privileges to send signals to processes that do not belong to you.
* Other process related commands:
    pstree Outputs a process list arranged in a tree-like pattern showing the parent/child relationships between processes.
    vmstat Outputs a snapshot of system resource usage including, memory, swap and disk I/O. To see a continuous display, follow the command with a time delay (in seconds) for updates. For example: vmstat 5. Terminate the output with Ctrl-c.
    xload A graphical program that draws a graph showing system load over time.
    tload Similar to the xload program, but draws the graph in the terminal. Terminate the output with Ctrl-c.
* The shell stores two basic types of data in the environment: environment variables and shell variables. shell variables are bits of data placed there by **bash**, and environment variables are everything else.
* The **set** command will show both the shell and environment variables, while **printenv** will only display the latter.
* Try: echo $HOME
* Startup Files for login shell sessions:
    /etc/profile A global configuration script that applies to all users.
    ~/.bash_profile A user's personal startup file. Can be used to extend or override settings in the global configuration script.
    ~/.bash_login If ~/.bash_profile is not found, bash attempts to read this script.
    ~/.profile If neither ~/.bash_profile nor ~/.bash_login is found, bash attempts to read this file.
* Startup Files for non-login shell sessions:
    /etc/bash.bashrc A global configuration script that applies to all users.
    ~/.bashrc A user's personal startup file. Can be used to extend or override settings in the global configuration script.
* In addition to reading the startup files above, non-login shells also inherit the environment from their parent process, usually a login shell.
* The changes made to **.bashrc** will not take affect until restart terminal session. We can use **source** command to re-read it.
* The INVOCATION section of the **bash** man page covers the **bash** startup files in gory details.
* Escape codes used in shell prompts:
    \a ASCII bell. This makes the computer beep when it is encountered.
    \d Current date in day, month, date format. For example, “Mon May 26.”
    \h Hostname of the local machine minus the trailing domain name.
    \H Full hostname.
    \j Number of jobs running in the current shell session.
    \l Name of the current terminal device.
    \n A newline character.
    \r A carriage return.
    \s Name of the shell program.
    \t Current time in 24 hour hours:minutes:seconds format.
    \T Current time in 12 hour format.
    \@ Current time in 12 hour AM/PM format.
    \A Current time in 24 hour hours:minutes format.
    \u username of the current user.
    \v Version number of the shell.
    \V Version and release numbers of the shell.
    \w Name of the current working directory.
    \W Last part of the current working directory name.
    \! History number of the current command.
    \# Number of commands entered during this shell session.
    \$ This displays a “$” character unless we have superuser privileges. In that case, it displays a “#” instead.
    \[ Signals the start of a series of one or more non-printing characters. This is used to embed non-printing control characters which manipulate the terminal emulator in some way, such as moving the cursor or changing text colors.
    \] Signals the end of a non-printing character sequence.
* Packaging management systems usually consist of two types of tools: low-level tools which handle tasks such as installing and removing package files, and high-level tools that perform metadata searching and dependency resolution.
* Finding a package in a repository: yum search search_string
* Installing a package from a repository: yum install package_name
* Installing a package from a package file: rpm -i package_file
* Removing a package: yum erase package_name
* Updating packages from a repository: yum update
* Updating a package from a package file: rpm -U package_file
* Listing installed packages: rpm -qa
* Determining if a package is installed: rpm -q package_name
* Displaying info about an installed package: yum info package_name
* Finding which package installed a File: rpm -qf file_name, such as: rpm -qf /usr/bin/vim
* mount – Mount a file system
    * umount – Unmount a file system
    * fsck – Check and repair a file system
    * fdisk – Partition table manipulator
    * mkfs – Create a file system
    * fdformat – Format a floppy disk
    * dd – Write block oriented data directly to a device
    * genisoimage (mkisofs) – Create an ISO 9660 image file
    * wodim (cdrecord) – Write data to optical storage media
    * md5sum – Calculate an MD5 checksum
* **/etc/fstab** (short for "file system table") lists the devices (typcially hard disk partitions) that are to be mounted at boot time.
* Unmounting a device entails writing all the remaining data to the device so that is can be safely removed.
* For new devices: 1. create a new partition 2. create file system on the drive
* Manipulate partitions with **fdisk**: we must first umount it (if needed) and then invoke the **fdisk**, such as: fdisk /dev/sdb, not /dev/sdb1
* Create a new file system with **mkfs**: mkfs -t ext4 /dev/sdb1
* Testing and repairing file systems: fsch
* Formatting floppy disks:
    fdformat /dev/fd0
    mkfs -t msdos /dev/fd0
* Moving data directly to/from devices: dd if=/dev/sdb of=/dev/sdc
* Create an image copy of a cdrom: dd if=/dev/cdrom of=ubuntu.iso
* Create an image from a collection of files: genisoimage -o cdrom.iso -R -J ~/cd-rom-files.  
* Mount an iso image directly: mount -t iso9660 -o loop image.iso /mnt/iso_image
* Blanking a re-writable CD-ROW: wodim dev=/dev/cdrw black=fast
* Writing an image: wodim dev=/dev/cdrw image.iso
* The **ip** program replaces the earlier and now deprecated **ifconfig** prograom.
* To examine the network interfaces: netstat -ie
* To display the kernel's network routing table: netstat -r
* ssh allows us to execute a single command on a remote system, such as: ssh remote-sys free
* sftp has an important advantage over conventional ftp in that it does not require an FTP server to be running on the remote host. It only requires the SSH server.
* locate -- Find files by name
* find -- search for files in a directory hierarchy, through application of options, tests and criteria. Examples:
    * find ~ \( -type f -not -perm 0600 \) -or \( -type d -not -perm 0700 \)
    * Predefined Actions: -delete, -ls, -print, -quit
    * The order of the tests and actions is important.
    * find ~ -name "\*.jpg" -exec rm '{}' ';'
    * find ~ -type f -name 'foo\*' -ok ls -l '{}' ';'
    * Improving Efficiency (combine the results of the search into an argument list): find ~ -type f -name 'foo\*' -exec ls -l '{}' +
    * find ~ -type f -name 'foo\*' -print | xargs ls -l
    * Funny filenames: find ~ -iname '\*.jgp' -print0 | args --null ls -l
* xargs -- Build and execute command lines from standard input
* The file compression programs: **<font color='red'>gzip/gunzip/zcat/zless</font>**, **<font color='blue'>bzip2/bunzip2/bzcat/bip2recover</font>**
    * **gzip Options**:
    * -c Write output to standard output and keep original files. May also be specified with --stdout and --to-stdout.
    * -d Decompress. This causes gzip to act like gunzip. May also be specified with --decompress or --uncompress.
    * -f Force compression even if a compressed version of the original file already exists. May also be specified with --force.
    * -h Display usage information. May also be specified with --help.
    * -l List compression statistics for each file compressed. May also be specified with --list.
    * -r If one or more arguments on the command line are directories, recursively compress files contained within them. May also be specified with --recursive.
    * -t Test the integrity of a compressed file. May also be specified with --test.
    * -v Display verbose messages while compressing. May also be specified with --verbose.
    * -number Set amount of compression. number is an integer in the range of 1 (fastest, least compression) to 9 (slowest, most compression). The values 1 and 9 may also be expressed as --fast and --best, respectively. The default value is 6.
    * **Examples**:
    * gzip -d -c foo.txt.gz | less
    * ls -l /etc | gzip > foo.txt.gz
* 
* The archiving programs: tar, zip
* tar mode[options] pathname...
    * **tar Modes**:
    * c Create an archive from a list of files and/or directories.
    * x Extract an archive.
    * r Append specified pathnames to the end of an archive.
    * t List the contents of an archive.
    * **Examples**:
    * tar xf archive.tar --wildcards 'home/simon/palyground/dir-\*/file-A'
    * find playground -name 'file-A' -exec tar rf archive.bar '{}' '+'
    * find playground -name 'file-A' | tar cf - --files-from=- | gzip > archive.tgz
    * find playground -name 'file-A' | tar cjf archive.tbz -T -
* Transferring files between systems over a network: ssh remote-sys 'tar cf - Documents' | tar xf -
* The main use of zip/unzip programs is for exchanging files with Windows system. 
* Examples:
* zip -r archive.zip playground
* unzip -l archive.zip playground/dir-001/file_Z
* find playground -name 'file-A' | zip -@ file-A.zip
* ls -l /etc/ | zip ls-etc.zip -
* unzip -p ls-etc.zip | less
* rsync: remote file and directory synchronization. rsync options source dest, where source and dest are one of the following:
    * a local file or directory
    * a remote file or directory in the form of [user@]host:path
    * a remote rsync server specified with a URI of rsync://[user@]host[:port]/path
* Examples: rsync -av --delete playground foo
* When passing regular expressions containing metacharacters on the command line, it is vital that they are enclosed in quotes to prevent the shell from attempting to expand them.
* The regular expression '^$' will match blank lines.
* The caret ^ character only invokes negation if it is the first character within a bracket expression; otherwise, it loses its special meaning.
* Systems using ASCII used a collation order: ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
* This differs from proper dictionary order: aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ
* Two different results:
    * ls /usr/sbin/[ABCDEFGHIJKLMNOPQRSTUVWXYZ]\*
    * ls /usr/sbin/[A-Z]\*
* To partially work around this problem, the POSIX standard includes a number of character classes which provides useful ranges of characters. But there is still no convenient way to express partial ranges, such as [A-M].
* The grep supports extends regular expressions when the -E option is used. Or we can just use egrep.
    * grep -Eh '^(bz|gz|zip)' filelist
    * grep -Eh '^bz|gz|zip' filelist
* Basic regular expressions (BRE) metacharacters: ^ $ . [ ] *
* Extended regular expressions (ERE) metacharacters: ( ) { } ? + |
* The "(", ")", "{" and "}" characters are treated as metacharacters in BRE if they are escaped with a backslash, whereas with ERE, preceding any metacharacter with a backslash causes it to be literal.
* Sentence search: echo "This works." | grep -E '[[:upper:]][[:upper:][:lower:] ]\*\.'
* Whereas grep will print a line when the line contains a string that matches an expression, find requires that the pathname exactly match the regular expression. For example: find . -regex '.*[^-_./0-9a-zA-Z].*'
* The locate program supports both basic (the --regexp option) and extended (the --regex option) regular expressions.
* vim supports basic regular expressions.
* cat has some useful options: -A(display non-printing characters), -s(suppress the output of multiple blank lines), -n(number lines)
* declare -r VAR="VALUE", use this to create read-only variable. Note that in an assignment, there must be no spaces between the variable name, the equals sign, and the value.
* Some examples:
    a=z #Assign the string "z" to variable a.
    b="a string" #Embedded spaces must be within quotes.
    c="a string and $b #Other expansions such as variables can be expanded into the assignment.
    d=$(ls -l foo.txt) #Results of a command.
    e=$((5 * 7)) #Arithmetic expansion.
    f="\t\ta string\n" #Escape sequences such as tabs and newlines.
* During expansion, variable names may be surrounded by optional curly braces "{}". This is useful in cases where a variable name becomes ambiguous due to its surrounding context. Such as: mv $filename ${filename}1
* A here document is an additional form of IO redirection in which we embed a bodyof text into script and feed it into the standard input of a command. Single and double quotes within here documents lose their special meaning to the shell.
* Here documents can be used with any command that accepts standard input. If we change the redirection operation from "<<" to "<<-", the shell will ignore leading tab characters in the here document. This allows a here document to be indented, which can improve readability. Here is an example:
```shell
#!/bin/bash
# Script to retrieve a file via FTP

FTP_SERVER=ftp.nl.debian.org
FTP_PATH=/debian/dists/lenny/main/installer-i386/current/images/cdrom
REMOTE_FILE=debian-cd_info.tar.gz

ftp -n <<- _EOF_
    open $FTP_SERVER
    user anonymous me@linuxbox
    cd $FTP_PATH
    hash
    get $REMOTE_FILE
    bye
    _EOF_
ls -l $REMOTE_FILE
```
* The **bash** man page includes a section entitled "HERE DOCUMENTS", which has a full description of this feature.  
* Use **local** to create local variable within functions.
* The **if** statement has the following syntax:
```shell
if commands; then
commands
[elif commands; then
commands...]
[else
commands]
fi
```
If a list of commands follows **if**, the last command in the list if evaluated.
* By convention, a value of zero indicates success and any other value indicates failure. The shell parameter**$?** contains the exit status. Man pages often includes a section entitled "Exit Status".
* The **true** command always executes successfully and the **false** command always executes unsuccessfully.
* The command used most frequently with **if** is **test**. The **test** command has two equivalent forms: *test expression*, and the more popular: **[ expression ] **. Note that both **test** and **[** are actually builtin commands. The expression is actually just its arguments with the **[** command requiring that the "]" character be provided as its final argument.
```shell
if [ $((INT % 2)) -eq 0 ]; then
echo "INT is even."
else
echo "INT is odd."
fi
```
See the test manual page for a list availabe options.
* Remember to use **return** instead of **exit** in shell functions. 
* Recent versions of **bash** support a compound command: **[[ expression ]]**. It is very similar to **test**(all of its expressions), but adds an important new string expression: **string1 =~ regex**, which returns true if *string1* is matched by the extended regular expression *regex*.
```shell
#!/bin/bash

# test-integer2: evaluate the value of an integer.

INT=-5

if [[ "$INT" =~ ^-?[0-9]+$ ]]; then
    exit 0
else
    echo "INT is not an integer." >&2
    exit 1
fi
```
* Another added feature of **[[ ]]** is that the **==** operator supports pattern matching the same way pathname expansion does.
```shell
[me@linuxbox ~]$ FILE=foo.bar
[me@linuxbox ~]$ if [[ $FILE == foo.* ]]; then
> echo "$FILE matches pattern 'foo.*'"
> fi
```
This makes **[[ ]]** useful for evaluating file and pathnames.
* **bash** supports the **(( ))** compound command, which is useful for operating on integers. **(( ))** is used to perform *arithmetic truth tests*. An arithmetic truth test resutls in true if the result of the arithmetic evaluation if non-zero. We can use **>**, **<** or **==** to test for equivalence, which is more natural-looking syntax for working with integers.
* Because the compound command **(( ))** is part of the shell syntax rather than an ordinary command, and it deals only with integers, it is able to recognize variables by name and does not require expansion to be performed.
```shell
INT=-5
if (( ((INT % 2)) == 0)); then
    echo "INT is even."
else
    echo "INT is odd."
fi
```
* Expressions can be combined by using logical operations, which are AND, OR and NOT.
    * Logical Operators
    <table>
    <tr> <th> Operation</th><th> test</th> <th> [[ ]] and (( ))</th> </tr>
    <tr> <td>AND</td><td> -a</td><td> &&</td> </td>
    <tr> <td>OR</td><td> -o</td><td> ||</td> </tr>
    <tr> <td>NOT</td><td> !</td><td> !</td> </tr>
    </table>
```shell
if [[ INT -ge MIN_VAL && INT -le MAX_VAL ]];
is the same as:
if [ $INT -ge $MIN_VAL -a $INT -le $MAX_VAL ];
```
* Practical examples:
```shell
[me@linuxbox ~]$ mkdir temp && cd temp
[me@linuxbox ~]$ [[ -d temp ]] || mkdir temp
```
* read -- read values from standard input. If no variables are listed after the **read** command, a shell variable, **REPLY**, will be assigned all the input.
* We can adjust the value of **IFS**(for Internal Field Separator) to control the separation of fields input to **read**.
```shell
FILE=/etc/passwd 
read -p "Enter a username > " user_name 
file_info=$(grep "^$user_name:" $FILE) 

if [ -n "$file_info" ]; then 
    IFS=":" read user pw uid gid name home shell <<< "$file_info" 
    echo "User = '$user'" 
    echo "UID = '$uid'" 
    echo "GID = '$gid'" 
```
The shell allows one or more variable assignments to take place immediately before a command. These commands alter the environment for the command that follows. The effect of the assignment is temporary; only changing the environment for the duration of the command.

The <<< operator indicates a *here string*, constisting of a single string.
* `echo "foo" | read`, The command will appear to succeed but the **REPLY** variable will be always be empty, because **read** is executed in a subshell.
* Some tricks in an example:
```shell
invalid_input () {
    echo "Invalid input '$REPLY'" >&2
        exit 1
}
read -p "Enter a single item > "
# input is empty (invalid)
[[ -z $REPLY ]] && invalid_input

# input is multiple items (invalid)
(( $(echo $REPLY | wc -w) > 1 )) && invalid_input

# is input a valid filename?
if [[ $REPLY =~ ^[-[:alnum:]\._]+$ ]]; then
    echo "'$REPLY' is a valid filename."
    if [[ -e $REPLY ]]; then
    echo "And file '$REPLY' exists."
    else
    echo "However, file '$REPLY' does not exist."
    fi
# is input a floating point number?
    if [[ $REPLY =~ ^-?[[:digit:]]*\.[[:digit:]]+$ ]]; then
    echo "'$REPLY' is a floating point number."
    else
    echo "'$REPLY' is not a floating point number."
    fi
fi
```
---
---
* loop examples:
```shell
count=1 
until [[ $count -gt 5 ]]; do 
# while [[ $count -le 5 ]]; do
        echo $count 
        count=$((count+1)) 
done 
```
Reading Files with loop:
```shell
while read distro version release; do
printf "Distro: %s\tVersion: %s\tReleased: %s\n" \
$distro \
$version \
$release
done < distros.txt
```
Another way (pipe):
```shell
sort -k 1,1 -k 2n distros.txt | while read distro version release; do
printf "Distro: %s\tVersion: %s\tReleased: %s\n" \
$distro \
$version \
$release
done
```
**bash** provides a method of tracing, implemented by the **-x** option and the **set** command with the **-x** option.
```shell
#!/bin/bash -x
```
To perform a trace on a selectd portion of a script, rather than the entire script, we can use this:
```shell
set -x  # Turn on tracing
...
set +x  # Turn off tracing
```
* The contents of **PS4** variable can make the trace prompt more useful, such as: ```export PS4='$LINENO + '```

---
---

* In bash, multiple-choice compound command is called **case**. The patterns used by **case** are the same as those used by pathname expansion. Patterns are terminated with a ")" character. 
 **case Pattern Examples**:
  * a)  Matches if word equals “a”.
  * [[:alpha:]]) Matches if word is a single alphabetic character.
  * ???)  Matches if word is exactly three characters long.
  * *.txt)  Matches if word ends with the characters “.txt”.
  * *)  Matches any value of word. It is good practice to include this as the last pattern in a case command, to catch any values of word that did not match a previous pattern; that is, to catch any possible invalid values.
```shell
read -p "enter word > "
case $REPLY in
    [[:alpha:]]) echo "..." ;;
    [ABC][0-9]) echo "..." ;;
    ???)  echo "..." ;;
    *.txt) echo "..." ;;
    *) echo "..." ;;
esac
```
* It is also possible to combine multiple patterns using the **"|"** as a separator. This creates an "or" conditional pattern.
```shell
case $REPLY in
q|Q) echo "Program terminated"
    exit
```
* Performing multiple actions: In bash prior to version 4.0 there was no way for **case** to match more than one test. Modern versions of bash, add the **";;&"** notation to terminate each action.
```shell
read -n 1 -p "Type a character > "
echo
case $REPLY in
[[:upper:]]) echo "'$REPLY' is upper case." ;;&
[[:lower:]]) echo "'$REPLY' is lower case." ;;&
[[:alpha:]]) echo "'$REPLY' is alphabetic." ;;&
[[:digit:]]) echo "'$REPLY' is a digit." ;;&
[[:graph:]]) echo "'$REPLY' is a visible character." ;;&
[[:punct:]]) echo "'$REPLY' is a punctuation symbol." ;;&
[[:space:]]) echo "'$REPLY' is a whitespace character." ;;&
[[:xdigit:]]) echo "'$REPLY' is a hexadecimal digit." ;;&
esac
```
----
### Chapter32 - Positional Parameters
* The shell provides a set of variables called *positional parameters* that contain the individual words on the command line. The variables are named 0 through 9. $0 will always contain the pathname of the program being executed.

* You can actually access more than nine parameters using parameter expansion. To specify a number greater than nine, surround the number in braces. For example ${10}, ${55}, and so on.
* The shell also provides a variable, $#, that contains the number of arguments on the command line.
* The **shift** command causes all the parameters (except $0, which never changes ) to "move down one" each time it is executed.
```shell
count=1
while [[ $# -gt 0 ]]; do
    echo "Argument $count = $1"
    count=$((count + 1))
    shift
done
```
* Positional parameters can also be used to pass arguments to shell functions. Such as this shell function:
```shell
file_info() {
    if [[ -e $1 ]]; then
        echo -e "\nFile Type:"
        file $1
        echo -e "\n File Status:"
        stat $1
    else
        echo "$FUNCNAME: usage: $FUNCNAME file" >&2
        return 1
    fi
}
```
* To manage all the positional parameters as a group, the shell provides two special parameters. They both expand into the complete list of positional parameters, but differ in rather subtle ways.
  * $* Expands into the list of positional parameters, starting with 1.  When surrounded by double quotes, it expands into a double quoted string containing all of the positional parameters, each separated by the first character of the IFS shell variable (by default a space character).
  * $@ Expands into the list of positional parameters, starting with 1.  When surrounded by double quotes, it expands each positional parameter into a separate word surrounded by double quotes.
```shell
print_params() {
    echo "\$1 = $1"
    echo "\$2 = $2"
    echo "\$3 = $3"
    echo "\$4 = $4"
}
pass_params() {
    echo -e "\n" '$* :'; print_params $*
    echo -e "\n" '"$*" :'; print_params "$*"
    echo -e "\n" '$@ :'; print_params $@
    echo -e "\n" '"$@" :'; print_params "$@"
}
pass_params "word" "words with spaces"
```
* The lesson to take from the above example is that even though the shell provides four different ways of getting the list of positional parameters, "$@" is by far the most useful for most situation, because it preserves the integrity of each positional parameter.
* **bash** includes a builtin command called **getopts**, which can also be used for process command line arguments.

---
### Chapter 33 Looping with *for*
---
* The really powerful feature of **for** is the interesting ways we can create thelist of words.
    * brace expansion:```for i in {A..D}; do echo $i; done
    * pathname expansion: ```for i in distros*.txt; do echo $i; done
    * command substitution:
 (If the optional in *words* portion of the for command is omitted, for defaults to processing the positional parameters)
```shell
for i; do
    if [[ -e $i ]]; then
        max_words=
        max_len=0
        for j in $(strings $i); do
            len=$(echo -n $j | wc -c)
            if (( len > max_len )); then
                max_words=$j
                max_len=$len
            fi
        done
        echo "$i: '$max_words' ($max_len  characters)"
    fi
done
```
* Another type of for loop: 
```shell
for (( i=0; i<5; i=i+1)); do echo $i; done
```
*
=======
* loop examples:
```shell
count=1 
until [[ $count -gt 5 ]]; do 
# while [[ $count -le 5 ]]; do
        echo $count 
        count=$((count+1)) 
done 
```
Reading Files with loop:
```shell
while read distro version release; do
printf "Distro: %s\tVersion: %s\tReleased: %s\n" \
$distro \
$version \
$release
done < distros.txt
```
Another way (pipe):
```shell
sort -k 1,1 -k 2n distros.txt | while read distro version release; do
printf "Distro: %s\tVersion: %s\tReleased: %s\n" \
$distro \
$version \
$release
done
```
* 
