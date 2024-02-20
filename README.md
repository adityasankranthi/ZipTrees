# CompSt 751 Group Project

## Name

Please put your current or desired project name here.

Project Name - ZIP Trees

## People

Please list all the team members with name, github username and email,e.g. 
John Boyland, @boyland, boyland@uwm.edu

Aditya Sankranthi ,@Aditya-Sankranthi , sankran5@uwm.edu 
Manasa Jayasri Thambabathula,@manasa-uwm ,thambab2@uwm.edu 
Satish Jagadish,@Satish7940, jagadis2@uwm.edu


## Paper

Give the URL to the ACM digital library for the paper you will be replicating.

https://dl.acm.org/doi/abs/10.1145/3476830


### Scope

Describe what you will be implementing.

(Base Implementation): The core of the project involves coding the Zip Trees data structure, incorporating key operations such as insertion, deletion, and search, following the algorithmic descriptions provided in the paper.

Insertion: We will incorporate a new node by assigning it a random rank, integrating it into the tree while ensuring the preservation of the heap order, based on ranks, alongside the binary search tree properties.

Deletion: We will remove nodes from the tree and subsequently restructure it to maintain the heap order and binary search tree properties. This process may involve the recombination of two subtrees to ensure the tree's integrity.

Search: We will implement search functionality similar to traditional binary search trees, traversing the tree based on key comparisons to locate the desired node efficiently.

These operations are facilitated by the novel concept of "zipping" and "unzipping" the tree for restructuring, which is simpler and potentially more efficient than the rotations used in AVL or red-black trees. The implementation focuses on the practical application of the theoretical principles discussed, including the random rank assignment and the management of these ranks to ensure the tree's efficiency and balance.




### Artifacts found

Give URLs of code provided by the authors of the paper or their collaborators.


## Plan

### Main classes

What classes will you implement to demonstrate the technique of the paper?

The main classes to implement for demonstrating the Zip Trees technique would include:

ZipTree: This class represents the core Zip Tree data structure, incorporating methods for insertion, deletion, and search operations based on the algorithmic descriptions provided in the paper.
ZipNode: This class represents the nodes within the Zip Tree, each containing a key, a random rank, and references to its left and right children.




### Helper classes

Are there any helpers you need to implement?
These can be from other open source projects, as long as you credit them


No specific helper classes from other open-source projects are mentioned. However, depending on the language and framework used, standard libraries or utilities for testing (e.g., JUnit for Java) may be leveraged.

### Test Suites

Provide a section for each test suite that is planned and a paragraph describing what it will do.

Functionality testing (TestZipTrees.java):
This suite focuses on functionality testing, including unit tests for insertion, deletion, and search operations. It will cover normal cases, boundary conditions, and error scenarios to ensure the correctness of each operation under various circumstances. For insertion, tests will validate that elements are added correctly while maintaining the tree properties. Deletion tests will ensure accurate removal of elements without compromising the tree's integrity, and search tests will confirm the correct retrieval of elements.

Data Structure Well-Formed-Ness Tests (TestInvariant.java):
This suite verifies the integrity of the Zip Tree's data structure after operations. It ensures that the heap order based on ranks and the binary search tree properties are preserved, confirming the structural soundness of the Zip Tree under different scenarios.

Efficiency Tests (TestEfficiency.java):
This suite evaluates the performance of Zip Tree operations, focusing on time complexity. It aims to compare the efficiency of insertion, deletion, and search operations against theoretical expectations, providing insights into the practical performance of the Zip Trees data structure.

Random Tests (TestGen.java):
These tests simulate unpredictable usage scenarios by generating random inputs and operations. The goal is to cover a broader range of possibilities, complementing primary unit tests and ensuring the Zip Tree handles diverse scenarios effectively.


#### Functionality testing
Functionality testing (TestZipTrees.java):
This suite focuses on functionality testing, including unit tests for insertion, deletion, and search operations. It will cover normal cases, boundary conditions, and error scenarios to ensure the correctness of each operation under various circumstances. For insertion, tests will validate that elements are added correctly while maintaining the tree properties. Deletion tests will ensure accurate removal of elements without compromising the tree's integrity, and search tests will confirm the correct retrieval of elements.


## Status

Add section using the current date as the heading and describe the status in a few sentences or a few paragraphs.

Status (as of current date: 02-19-2024)
The project plan is well-defined, with the main classes identified and comprehensive test suites outlined to ensure the functionality and efficiency of the Zip Trees implementation. The initial coding phase is underway, with a focus on meeting the outlined milestones and completing the primary functionality tests.









