
## Help
1. Run **:help user-manual** and browse through the list of contents of the entire user manual and read the chapter that you feel is relevant to what you're trying to do.

2. "ctrl+]" and "ctrl+o" can navigate inside help manual.

3. **:helpgrep** commmand can search for a phrase. You can use **:cnext** and **:cprev** to move to the next and previous part of documentation where that phrase occurs. Use **:clist** to see the whole list.

4. Run ```:swapname``` to show the swap file name. See **:help swap-file**.  

5. The make saving easier, add the following line to your vimrc file:
```
" To save, ctrl-s
nmap <c-s> :w<CR>
imap <c-s> <Esc>:w<CR>a
```

6. **dl**: delete one charactor.
**yap**: copy the current paragraph.
**xp**: swap two characters.
**dwwP**: swap two words. 

7. Create a mark by pressing **m** followed by the name of the mark which is a single character from a-zA-Z. Like, **ma**.
Pressing **'a** returns cursor to line of the mark. Pressing **`a** will returns to the exact line and column of the mark.

8. Some examples of undo/redo:
```
:earlier 4m
:later 45s
:undo 5
:undolist
```
See **:help :undolist** for explanation of the output from this command.
See **:help undo-redo** and **:help usr-32.txt**.

9. Setting for search:
```
set incsearch
set ignorecase
set smartcase
```
When you have **smartcase** on:
 * If you are searching for **/step**, then it will search for any combination of upper and lower case text.
 * If you are searching for **/Step**, then it will search for ONLY text that matches the exact case.

## Muliplicity
1. Switch between buffers: **:e <filename>** or **:b <index>**

2. Show buffers loaded: **:buffers** or **:ls**

3. Delete buffer: **:bd <index>**.
See **:help buffer-list**

4. Switch between windows: **ctrl_w <motion key>** or **ctrl_w ctrl_w**.
Create a horizontal window: **ctrl_w s** or **:sp**
Create a vertical window: **ctrl_w v** or **:vsp**

5. Rotate the windows: **ctrl_w r**
Move the current window to the topmost position: **ctrl_w K**
Resize the window: **:resize 10**
Make the current window as big as possible: **ctrl_w _**
Make the window lenght equal: **ctrl_w =**
See **:help windows**

6. Open a new tab: **:tabnew**, switch between tabs: **gt**, **gT**, close a tab: **:tabc** or **:q**.
You can add the following lines to **vimrc** file:
```
" Shortcuts for moving between tabs
noremap <A-j> gT
noremap <A-k> gt
```

7. Open help in a new tab: **:tab help ..** 
Reorder the tabs: **:tabmove**, like **:tabmove 0**

8. Operate on each of the tab pages: **:tabdo**
Customize the title of the tab pages: **:help setting-guitablabel**

## Plugins
1. There are various kinds of plugins:
 * vimrc
 * global plugin
 * filetype plugin
 * syntax highlighting plugin
 * compiler plugin

2. There are two files you can create to customize Vim to your taste:
 * vimrc - for general customizations
 * gvimrc - for GUI specific customizations 

3. A example for vimrc:
```markdown
" Use Vim settings, rather then Vi settings (much better!).
" This must be first, because it changes other options as a side
effect.
set nocompatible
" Enable syntax highlighting.
syntax on
" Automatically indent when adding a curly bracket, etc.
set smartindent
" Tabs should be converted to a group of 4 spaces.
" This is the official Python convention
" (http://www.python.org/dev/peps/pep-0008/)
" I didn't find a good reason to not use it everywhere.
set shiftwidth=4
set tabstop=4
set expandtab
set smarttab
" Minimal number of screen lines to keep above and below the cursor.
set scrolloff=999
" Use UTF-8.
set encoding=utf-8
" Set color scheme that I like.
if has( "gui_running" )
 colorscheme desert
else
 colorscheme darkblue
endif
" Status line
set laststatus=2
set statusline=
set statusline+=%-3. 3n\ " buffer number
set statusline+=%f\ " filename
set statusline+=%h%m%r%w " status flags
set statusline+=\[%{strlen( &ft)?&ft: 'none' }] " file type
set statusline+=%= " right align remainder
set statusline+=0x%-8B " character value
set statusline+=%-14(%l,%c%V%) " line, character
set statusline+=%<%P " file position
" Show line number, cursor position.
set ruler
" Display incomplete commands.
set showcmd
" To insert timestamp, press F3.
nmap <F3> a<C-R>=strftime( "%Y-%m-%d %a %I:%M %p" ) <CR><Esc>
imap <F3> <C-R>=strftime( "%Y-%m-%d %a %I:%M %p" ) <CR>
" To save, press ctrl-s.
nmap <c-s> : w<CR>
imap <c-s> <Esc>: w<CR>a
" Search as you type.
set incsearch
" Ignore case when searching.
set ignorecase
" Show autocomplete menus
set wildmenu
" Show editing mode
set showmode
" Error bells are displayed visually.
set visualbell
```

4. A example for gvimrc:
```
" Size of GVim window
set lines=35 columns=99
" Don't display the menu or toolbar. Just the screen.
set guioptions-=m
set guioptions-=T
" Font. Very important.
if has( 'win32' ) || has( 'win64' )
 " set guifont=Monaco:h16
"
http: //jeffmilner. com/index.php/2005/07/30/windows-vista-fonts-now-available/
 set guifont=Consolas:h12:cANSI
elseif has( 'unix' )
 let &guifont="Monospace 10"
endif
```
See: vi-improved.org's vimrc,  Amir Salihefendic's vimrc

5. Global plugins can be used to provide global/generic functionality. Can be stored in two places:
 * $VIMRUNTIME\plugin for standard plugins supplied by Vim during its installation.
 * %HOME%/vimfiles/plugin for your own plugins
See **:help runtimepath**.

6. **:make**: compile the file
**:clist**: see the full list of errors.
**:cnext**: move to the next error
See **:help quickfix**, and **:help write-compiler-plugin**

7. You can allow Vim to do selective initialization using the **-u** command line argument, like ```vim -u NONE```.
See **:help -u** and **:help starting**.


## Programmers Editor
1. If you want the power of syntax highlighting for command output, just pipe it to Vim, like ```svn diff | vim -R -```.

2. If you indent a particular line and want the lines following it to be also indented to the same level, you can use the **:set autoindent** setting.

3. If you start a new block of statements and want the next line to be automatically indented to the next level, use the **:set smartindent** setting. Note that the behavior of this setting is dependent on the particular programming language being used.

4. You can run a shell command from within Vim using the **:!** command. If you want access to a full-fledged shell, run **:sh**.
If you have a bunch of lines that you want to sort, then run **:%!sort**, this passes the current text to the sort command in the shell and then the output of that command replaces the current content of the file

5. Use **:Vex** and **:Sex** to browse the file system within Vim.
