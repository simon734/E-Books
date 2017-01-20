
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
