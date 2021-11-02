# Experimental results

We ran our code on a Dell Optiplex 9020 Dungeon Computer.
Our implementation had every client connection running on a separate thread on the server; whereas on the client, the input was handled on one thread while the output was handled on another. 

Running stress.bat on words.txt gave us the following results.

**Single threaded:**

13s to do 25 runs of `words.txt`

27s to do 50 runs of `words.txt`

**Multithreaded**

4s to do 25 runs of `words.txt`

9s to do 50 runs of `words.txt`

The current setup obviously benefits from the use of threads to handle client server connections concurrently. 